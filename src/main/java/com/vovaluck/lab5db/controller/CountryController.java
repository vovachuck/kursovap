package com.vovaluck.lab5db.controller;

import com.vovaluck.lab5db.model.Country;
import com.vovaluck.lab5db.repository.CountryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {
    @Autowired
    CountryRepository countryRepository;

    @RequestMapping("/get")
    public List<Country> getCountry()  {
        //return buildingService.getBuildings();
        return countryRepository.findAll();
    }

    @PostMapping("/insert")
    public Country insertCountry(@RequestBody Country country){
        //return buildingService.insertBuilding(book);
        return countryRepository.save(country);
    }
    @RequestMapping("/update")
    public Country updateCountry(@RequestBody Country country, @RequestParam("id")int id)  {
        country.setIdCountry(id);
        return countryRepository.save(country);
        //return buildingService.updateBuilding(book);
    }

    @RequestMapping("/del")
    public void deleteCountry(@RequestParam("id")int id)  {
        //buildingService.deleteBuilding(id);
        countryRepository.deleteById(id);
    }
}

