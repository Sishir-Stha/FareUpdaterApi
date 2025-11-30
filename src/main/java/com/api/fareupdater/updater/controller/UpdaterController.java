package com.api.fareupdater.updater.controller;

import com.api.fareupdater.common.constants.ApiConstants;
import com.api.fareupdater.common.constants.HttpConstants;
import com.api.fareupdater.common.utils.ErrorMessage;
import com.api.fareupdater.updater.Service.UpdaterService;
import com.api.fareupdater.updater.dto.request.FareDataRequest;
import com.api.fareupdater.updater.dto.response.FareDataResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
