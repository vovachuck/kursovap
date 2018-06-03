package com.vovaluck.lab5db.repository;


import com.vovaluck.lab5db.model.FinanceReport;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FinanceReportRepository extends JpaRepository<FinanceReport,Integer> {
    @Query("Select finance From FinanceReport finance " +
            "inner join GroupTourist groupTourist on groupTourist.idGroupTourist=finance.idFinanceReport "+
            "where groupTourist.nameGroup Like :nameGroup and groupTourist.category Like :category")
    List<FinanceReport> selectSomethingFinance(@Param("nameGroup") String nameGroup, @Param("category") String category);

}
