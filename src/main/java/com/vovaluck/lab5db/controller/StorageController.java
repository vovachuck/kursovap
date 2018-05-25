package com.vovaluck.lab5db.controller;

import com.vovaluck.lab5db.model.Storage;
import com.vovaluck.lab5db.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/storage")
public class StorageController {
    @Autowired
    StorageRepository storageRepository;

    @RequestMapping("/get")
    public List<Storage> getStorage()  {
        //return buildingService.getBuildings();
        return storageRepository.findAll();
    }

    @PostMapping("/insert")
    public Storage insertStorage(@RequestBody Storage storage){
        //return buildingService.insertBuilding(book);
        return storageRepository.save(storage);
    }
    @RequestMapping("/update")
    public Storage updateStorage(@RequestBody Storage storage, @RequestParam("id")int id)  {
        storage.setIdStorage(id);
        return storageRepository.save(storage);
        //return buildingService.updateBuilding(book);
    }

    @RequestMapping("/del")
    public void deleteStorage(@RequestParam("id")int id)  {
        //buildingService.deleteBuilding(id);
        storageRepository.deleteById(id);
    }
}

