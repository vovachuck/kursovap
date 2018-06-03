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


}
