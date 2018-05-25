package com.vovaluck.lab5db.controller;

import com.vovaluck.lab5db.model.Tour;
import com.vovaluck.lab5db.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tour")
public class TourController {
    @Autowired
    TourRepository tourRepository;

    @RequestMapping("/get")
    public List<Tour> getTour()  {
        //return buildingService.getBuildings();
        return tourRepository.findAll();
    }

    @PostMapping("/insert")
    public Tour insertTour(@RequestBody Tour tour){
        //return buildingService.insertBuilding(book);
        return tourRepository.save(tour);
    }
    @RequestMapping("/update")
    public Tour updateTour(@RequestBody Tour tour, @RequestParam("id")int id)  {
        tour.setIdTour(id);
        return tourRepository.save(tour);
        //return buildingService.updateBuilding(book);
    }

    @RequestMapping("/del")
    public void deleteTour(@RequestParam("id")int id)  {
        //buildingService.deleteBuilding(id);
        tourRepository.deleteById(id);
    }
}

