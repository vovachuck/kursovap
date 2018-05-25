package com.vovaluck.lab5db.controller;



import com.vovaluck.lab5db.model.Agency;
import com.vovaluck.lab5db.repository.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agency")
public class AgencyController {
    @Autowired
    AgencyRepository agencyRepository;

    @RequestMapping("/get")
    public List<Agency> getAgency()  {
        //return buildingService.getBuildings();
        return agencyRepository.findAll();
    }

    @PostMapping("/insert")
    public Agency insertAgency(@RequestBody Agency agency){
        //return buildingService.insertBuilding(book);
        return agencyRepository.save(agency);
    }
    @RequestMapping("/update")
    public Agency updateAgency(@RequestBody Agency agency, @RequestParam("id")int id)  {
        agency.setIdAgency(id);
        return agencyRepository.save(agency);
        //return buildingService.updateBuilding(book);
    }

    @RequestMapping("/del")
    public void deleteAgency(@RequestParam("id")int id)  {
        //buildingService.deleteBuilding(id);
        agencyRepository.deleteById(id);
    }
}

