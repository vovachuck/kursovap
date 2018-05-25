package com.vovaluck.lab5db.controller;


import com.vovaluck.lab5db.model.GroupTourist;
import com.vovaluck.lab5db.repository.GroupTouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grouptourist")
public class GroupTouristController {
    @Autowired
    GroupTouristRepository tourRepository;

    @RequestMapping("/get")
    public List<GroupTourist> getGroupTourist()  {
        //return buildingService.getBuildings();
        return tourRepository.findAll();
    }

    @PostMapping("/insert")
    public GroupTourist insertGroupTourist(@RequestBody GroupTourist groupTourist){
        //return buildingService.insertBuilding(book);
        return tourRepository.save(groupTourist);
    }
    @RequestMapping("/update")
    public GroupTourist updateGroupTourist(@RequestBody GroupTourist groupTourist, @RequestParam("id")int id)  {
        groupTourist.setIdGroupTourist(id);
        return tourRepository.save(groupTourist);
        //return buildingService.updateBuilding(book);
    }

    @RequestMapping("/del")
    public void deleteGroupTourist(@RequestParam("id")int id)  {
        //buildingService.deleteBuilding(id);
        tourRepository.deleteById(id);
    }
}

