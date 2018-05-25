package com.vovaluck.lab5db.controller;

import com.vovaluck.lab5db.model.Customs;
import com.vovaluck.lab5db.repository.CustomsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customs")
public class CustomsController {
    @Autowired
    CustomsRepository customsRepository;

    @RequestMapping("/get")
    public List<Customs> getHotel()  {
        //return buildingService.getBuildings();
        return customsRepository.findAll();
    }

    @PostMapping("/insert")
    public Customs insertBook( @RequestBody Customs customs){
        //return buildingService.insertBuilding(book);
        return customsRepository.save(customs);
    }
    @RequestMapping("/update")
    public Customs updateBook(@RequestBody Customs customs,@RequestParam("id")int id)  {
        customs.setIdCustoms(id);
        return customsRepository.save(customs);
        //return buildingService.updateBuilding(book);
    }

    @RequestMapping("/del")
    public void deleteBook(@RequestParam("id")int id)  {
        //buildingService.deleteBuilding(id);
        customsRepository.deleteById(id);
    }
}
