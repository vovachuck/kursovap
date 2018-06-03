package com.vovaluck.lab5db.repository;


import com.vovaluck.lab5db.model.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StorageRepository extends JpaRepository<Storage,Integer> {
    @Query("Select storage From Storage storage " +
            "where storage.arrivalDateCargo between  :date1 and :date2")
    List<Storage> selectSomethingStore(@Param("date1") LocalDate date1, @Param("date2") LocalDate date2);

}
