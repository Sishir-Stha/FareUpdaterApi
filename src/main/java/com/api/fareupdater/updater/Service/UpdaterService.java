package com.api.fareupdater.updater.Service;

import com.api.fareupdater.updater.Entity.FareEntity;
import com.api.fareupdater.updater.Entity.ResultEntity;
import com.api.fareupdater.updater.dto.response.FareDataResponse;
import com.api.fareupdater.updater.mapper.EntityToDto;
import com.api.fareupdater.updater.repository.UpdaterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Slf4j
@Service
public class UpdaterService {

    @Autowired
    private UpdaterRepository updaterRepository;

    @Autowired
    private EntityToDto mapper;


    public List<FareDataResponse> getFareData(String sector,String bookingClassRcd, String fareCode, String flightDate, String currency){

        List<FareEntity> fareDate = updaterRepository.getFareData(sector, bookingClassRcd, fareCode, flightDate, currency);
        List<FareDataResponse> responses = mapper.fareListMapper(fareDate);
        return responses;
    }

    public boolean updateFare(String fareid, Date flightdatefrom, Date flightdateto,
                              double fareamount, String validOnFlight,
                              String userlogon,  String actiontype){

        ResultEntity result = updaterRepository.updateFareData(fareid, flightdatefrom, flightdateto, fareamount, validOnFlight, userlogon, actiontype);

        int isTrue = result.getResult();
        if(isTrue == 1){
            return true;
        }else{
            return false;
        }
    }
}
