package com.api.fareupdater.updater.repository;

import com.api.fareupdater.updater.Entity.FareEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UpdaterRepository extends JpaRepository<FareEntity , String> {

    @Query(value = "EXEC uspUIFareSearch_umn1 :sector, :bookingClassRcd, :fareCode, :flightDate, :currency", nativeQuery = true)
    List<FareEntity> getFareData(@Param("sector") String sector,
                                 @Param("bookingClassRcd") String bookingClassRcd,
                                 @Param("fareCode") String fareCode,
                                 @Param("flightDate") String flightDate,
                                 @Param("currency") String currency);
}
