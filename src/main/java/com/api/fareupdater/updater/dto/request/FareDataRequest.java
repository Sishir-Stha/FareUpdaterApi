package com.api.fareupdater.updater.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FareDataRequest {

    @NotBlank(message = "Sector is required")
    private String sector;
    @NotNull
    private String bookingClassRcd;
    @NotNull
    private String fareCode;
    @NotBlank(message = "Flight Date is required")
    private  String flightDate;
    @NotBlank(message = "Currency is required")
    private String currency;
}
