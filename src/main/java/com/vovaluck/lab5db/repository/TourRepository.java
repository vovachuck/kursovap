package com.vovaluck.lab5db.repository;


import com.vovaluck.lab5db.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRepository extends JpaRepository<Tour,Integer> {

}
