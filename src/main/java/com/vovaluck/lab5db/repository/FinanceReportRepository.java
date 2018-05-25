package com.vovaluck.lab5db.repository;


import com.vovaluck.lab5db.model.FinanceReport;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinanceReportRepository extends JpaRepository<FinanceReport,Integer> {

}
