package com.api.fareupdater.updater.mapper;

import com.api.fareupdater.updater.Entity.FareEntity;
import com.api.fareupdater.updater.dto.response.FareDataResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EntityToDto {
    public List<FareDataResponse> fareListMapper(List<FareEntity> entities) {
        List<FareDataResponse> responses = new ArrayList<>();

        for (FareEntity entity : entities) {
            FareDataResponse dto = new FareDataResponse();
            dto.setFareId(entity.getFareId());
            dto.setSector(entity.getSector());
            dto.setBookRcd(entity.getBookRcd());
            dto.setFlightDateFrom(entity.getFlightDateFrom());
            dto.setFlightDateTo(entity.getFlightDateTo());
            dto.setFareAmount(entity.getFareAmount());
            dto.setValidOnFlight(entity.getValidOnFlight());
            responses.add(dto);
        }
        return responses;
    }
}
