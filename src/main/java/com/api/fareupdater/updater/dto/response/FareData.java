package com.api.fareupdater.updater.dto.response;

import jakarta.annotation.Nullable;
import lombok.Data;

@Data
public class FareData {

    private String fareId;
    private String sector;
    private String bookRcd;
    private String flightDateFrom;
    private String flightDateTo;
    private String fareAmount;
    @Nullable
    private String ValidOnFlight;

}
