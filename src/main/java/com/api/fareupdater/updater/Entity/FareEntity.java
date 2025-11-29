package com.api.fareupdater.updater.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class FareEntity {

    @Id
    @Column(name = "fare_id")
    private String fareId;

    @Column(name = "Sector")
    private String sector;

    @Column(name = "book_rcd")
    private String bookRcd;

    @Column(name = "flight_date_from")
    private String flightDateFrom;

    @Column(name = "flight_date_to")
    private String flightDateTo;

    @Column(name = "fare_amount")
    private String fareAmount;

    @Column(name = "valid_on_flight",nullable = true)
    private String ValidOnFlight;

}
