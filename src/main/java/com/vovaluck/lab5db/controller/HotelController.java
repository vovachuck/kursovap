package com.vovaluck.lab5db.controller;

import com.vovaluck.lab5db.model.Hotel;
import com.vovaluck.lab5db.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    HotelRepository hotelRepository;

    @RequestMapping("/get")
    public List<Hotel> getHotel()  {
        //return buildingService.getBuildings();
        return hotelRepository.findAll();
    }

    @PostMapping("/insert")
    public Hotel insertBook( @RequestBody Hotel hotel){
        //return buildingService.insertBuilding(book);
        return hotelRepository.save(hotel);
    }
    @RequestMapping("/update")
    public Hotel updateBook(@RequestBody Hotel hotel,@RequestParam("id")int id)  {
        hotel.setIdHotel(id);
        return hotelRepository.save(hotel);
        //return buildingService.updateBuilding(book);
    }

    @RequestMapping("/del")
    public void deleteBook(@RequestParam("id")int id)  {
        //buildingService.deleteBuilding(id);
        hotelRepository.deleteById(id);
    }

}
