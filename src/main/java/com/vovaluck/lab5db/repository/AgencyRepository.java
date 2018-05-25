package com.vovaluck.lab5db.repository;

import com.vovaluck.lab5db.model.Agency;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyRepository extends JpaRepository<Agency,Integer> {

}