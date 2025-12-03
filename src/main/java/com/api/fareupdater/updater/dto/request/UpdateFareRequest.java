package com.api.fareupdater.updater.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;

@Data
public class UpdateFareRequest {
    @NotEmpty(message ="Fare Id(s) is required" )
    List<String> fareid;
    @NotNull
    Date flightdatefrom;
    @NotNull
    Date flightdateto;
    @NotNull
    double fareamount;
    @NotNull
    String validonflight;
    @NotBlank(message = "User Id is required")
    String userlogon;
    @NotBlank(message = "Action Type is Required")
    String actiontype;

}
