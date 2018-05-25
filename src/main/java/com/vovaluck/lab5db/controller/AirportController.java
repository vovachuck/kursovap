package com.vovaluck.lab5db.controller;

import com.vovaluck.lab5db.model.Airport;


import com.vovaluck.lab5db.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airport")
public class AirportController {
    @Autowired
    AirportRepository airportRepository;

    @RequestMapping("/get")
    public List<Airport> getAirport()  {
        //return buildingService.getBuildings();
        return airportRepository.findAll();
    }

    @PostMapping("/insert")
    public Airport insertAirport(@RequestBody Airport airport){
        //return buildingService.insertBuilding(book);
        return airportRepository.save(airport);
    }
    @RequestMapping("/update")
    public Airport updateAirport(@RequestBody Airport airport, @RequestParam("id")int id)  {
        airport.setIdAirport(id);
        return airportRepository.save(airport);
        //return buildingService.updateBuilding(book);
    }

    @RequestMapping("/del")
    public void deleteAirport(@RequestParam("id")int id)  {
        //buildingService.deleteBuilding(id);
        airportRepository.deleteById(id);
    }
}

