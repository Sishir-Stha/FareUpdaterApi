package com.api.fareupdater.updater.Service;

import com.api.fareupdater.updater.Entity.FareEntity;
import com.api.fareupdater.updater.repository.UpdaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpdaterService {

    @Autowired
    private UpdaterRepository updaterRepository;

    public List<FareEntity> getFareData(String sector,String bookingClassRcd, String fareCode, String flightDate, String currency){

        List<FareEntity> fareDate = updaterRepository.getFareData(sector, bookingClassRcd, fareCode, flightDate, currency);
        return fareDate;

    }
}
