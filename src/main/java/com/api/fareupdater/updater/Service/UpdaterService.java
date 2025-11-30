package com.api.fareupdater.updater.Service;

import com.api.fareupdater.updater.Entity.FareEntity;
import com.api.fareupdater.updater.dto.response.FareDataResponse;
import com.api.fareupdater.updater.mapper.EntityToDto;
import com.api.fareupdater.updater.repository.UpdaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
