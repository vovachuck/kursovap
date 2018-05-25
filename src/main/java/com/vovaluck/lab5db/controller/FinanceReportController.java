package com.vovaluck.lab5db.controller;

import com.vovaluck.lab5db.model.FinanceReport;

import com.vovaluck.lab5db.repository.FinanceReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/financereport")
public class FinanceReportController {
    @Autowired
    FinanceReportRepository financeReportRepository;

    @RequestMapping("/get")
    public List<FinanceReport> getFinanceReport()  {
        //return buildingService.getBuildings();
        return financeReportRepository.findAll();
    }

    @PostMapping("/insert")
    public FinanceReport insertFinanceReport(@RequestBody FinanceReport financeReport){
        //return buildingService.insertBuilding(book);
        return financeReportRepository.save(financeReport);
    }
    @RequestMapping("/update")
    public FinanceReport updateFinanceReport(@RequestBody FinanceReport financeReport, @RequestParam("id")int id)  {
        financeReport.setIdFinanceReport(id);
        return financeReportRepository.save(financeReport);
        //return buildingService.updateBuilding(book);
    }

    @RequestMapping("/del")
    public void deleteFinanceReport(@RequestParam("id")int id)  {
        //buildingService.deleteBuilding(id);
        financeReportRepository.deleteById(id);
    }
}

