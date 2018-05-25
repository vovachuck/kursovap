package com.vovaluck.lab5db.repository;
import com.vovaluck.lab5db.model.Customs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface CustomsRepository extends JpaRepository<Customs,Integer> {

    }

