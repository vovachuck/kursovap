package com.vovaluck.lab5db.repository;

import com.vovaluck.lab5db.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport,Integer> {

}
