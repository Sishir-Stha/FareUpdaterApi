package com.api.fareupdater.updater.repository;

import com.api.fareupdater.updater.Entity.FareEntity;
import com.api.fareupdater.updater.Entity.ResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

public interface UpdaterRepository extends JpaRepository<FareEntity , String> {

    @Query(value = "EXEC uspUIFareSearch_umn1 :sector, :bookingClassRcd, :fareCode, :flightDate, :currency", nativeQuery = true)
    List<FareEntity> getFareData(@Param("sector") String sector,
                                 @Param("bookingClassRcd") String bookingClassRcd,
                                 @Param("fareCode") String fareCode,
                                 @Param("flightDate") String flightDate,
                                 @Param("currency") String currency);

    @Query(value = "EXEC uspFareChange_umn :fareid, :flightdatefrom, :flightdateto, :fareamount, :validOnFlight, :userlogon, :actionType",
            nativeQuery = true)
    ResultEntity updateFareData(@Param("fareid") String fareid,
                           @Param("flightdatefrom") Date flightdatefrom,
                           @Param("flightdateto") Date flightdateto,
                           @Param("fareamount") double fareamount,
                           @Param("validOnFlight") String validOnFlight,
                           @Param("userlogon") String userlogon,
                           @Param("actionType") String actionType);



}
