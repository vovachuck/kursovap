package com.vovaluck.lab5db.repository;

import com.vovaluck.lab5db.model.Airport;
import com.vovaluck.lab5db.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<Airport,Integer> {
    @Query("select airport from Airport airport " +
            "where airport.nameJourney Like :nameJourney ")
    List<Airport>selectAir(@Param("nameJourney") String nameJourney);

    @Query("select airport from Airport airport " +
            "where :date1 between  airport.departureDate and airport.dateArrival ")
    List<Airport>selectAirJour(@Param("date1") LocalDate date1);

}
