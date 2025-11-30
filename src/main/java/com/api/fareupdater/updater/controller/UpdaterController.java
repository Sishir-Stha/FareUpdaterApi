package com.api.fareupdater.updater.controller;

import com.api.fareupdater.common.constants.ApiConstants;
import com.api.fareupdater.common.constants.HttpConstants;
import com.api.fareupdater.common.utils.ErrorMessage;
import com.api.fareupdater.updater.Service.UpdaterService;
import com.api.fareupdater.updater.dto.request.FareDataRequest;
import com.api.fareupdater.updater.dto.request.UpdateFareRequest;
import com.api.fareupdater.updater.dto.response.FareDataResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping(ApiConstants.UPDATER_BASE)
public class UpdaterController {

    @Autowired
    private UpdaterService updaterService;

    @PostMapping("/getFareData")
    public ResponseEntity<?> getFareData( @Valid @RequestBody FareDataRequest request){

        try {
            List<FareDataResponse> responses = updaterService.getFareData(request.getSector(), request.getBookingClassRcd(), request.getFareCode(), request.getFlightDate(), request.getCurrency());
            if(!responses.isEmpty()){
                log.info("<< Fare List Retrived >>");
                return ResponseEntity.ok(responses);
            }else{
                log.debug("Fare data is null ( Either no Fare Exists or error in the database side )");
                return ResponseEntity.status(HttpConstants.INVALID_CREDENTIALS).body(new ErrorMessage(401,"The fare doesnt exists i.e is null"));
            }
        }catch(Exception e){
            log.error("Error occurred while fetching the fare date list: {}",request.getFlightDate(), e);
            return ResponseEntity.status(HttpConstants.INTERNAL_SERVER_ERROR).body(new ErrorMessage(500, "Internal Server Error !!"));
        }
    }

    @PutMapping("/updateFare")
    public ResponseEntity<?> updatefare(@Valid @RequestBody UpdateFareRequest request){
        int noOfFareId = request.getFareid().size();
        int updatedCount = 0;
        int failedcount =0;
        for( String fareId  : request.getFareid()){
            try{

                boolean isUpdated = updaterService.updateFare(fareId,request.getFlightdatefrom(),request.getFlightdateto(),request.getFareamount(),request.getValidonflight(),request.getUserlogon(),request.getActiontype());
                if (isUpdated){
                    updatedCount++;
                    log.info("Fare of Fare id  : "+  fareId +" is updated");
                }else{
                    failedcount++;
                    log.info("Fare of Fare id failed to update " +fareId);
                }
            }catch(Exception e){
                log.error("Error occurred while fetching the fare date list: {}",request.getFareid(), e);
                return ResponseEntity.status(HttpConstants.INTERNAL_SERVER_ERROR).body(new ErrorMessage(500, "Internal Server Error !!"));
            }finally {
                log.info("Fare Updated count  : " + updatedCount + "    Failed Fare count  : " + failedcount);
            }
            if(updatedCount == 0){
                return ResponseEntity.status(HttpConstants.FAILED).body(new ErrorMessage(422, "No Fares were Updated"));
            }
        }
        return ResponseEntity.ok(updatedCount+" Updated");
    }
}
