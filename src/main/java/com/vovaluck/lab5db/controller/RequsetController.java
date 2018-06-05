package com.vovaluck.lab5db.controller;

import com.vovaluck.lab5db.model.*;
import com.vovaluck.lab5db.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/request")
public class RequsetController {

    @Autowired
    RequestService requestService;

    @RequestMapping("/request1")
    List<GroupTourist> selectSomething(@RequestParam String nameCountry){
        return  requestService.selectSomething(nameCountry);
    }
    @RequestMapping("/request2")
    List<GroupTourist> selectSomethingHotel(@RequestParam String hotelName){
        return  requestService.selectSomethingHotel(hotelName);
    }
    @RequestMapping("/request3")
    List<GroupTourist> selectSomethingCountry(@RequestParam String category,@RequestParam String countryArrival,
                                              @RequestParam(value = "date1", required = true)
                                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date1,
                                              @RequestParam(value = "date2", required = true)
                                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date2){
        return  requestService.selectSomethingCountry(category,countryArrival,date1,date2);
    }
    @RequestMapping("/request3_1")
    List<GroupTourist> selectSomethingCountryAll(@RequestParam String countryArrival,
                                              @RequestParam(value = "date1", required = true)
                                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date1,
                                              @RequestParam(value = "date2", required = true)
                                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date2){
        return  requestService.selectSomethingCountryAll(countryArrival,date1,date2);
    }
    @RequestMapping("/request5")
    List<Agency> selectSomethingAgency(@RequestParam(value = "date1", required = true)
                                                 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date1,
                                       @RequestParam(value = "date2", required = true)
                                                 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date2){
        return  requestService.selectSomethingAgency(date1,date2);
    }
    @RequestMapping("/request9")
    List<Storage> selectSomethingStore(@RequestParam(value = "date1", required = true)
                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date1,
                                       @RequestParam(value = "date2", required = true)
                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date2){
        return  requestService.selectSomethingStore(date1,date2);
    }
    @RequestMapping("/request10")
    List<FinanceReport> selectSomethingFinance(@RequestParam String nameGroup, @RequestParam String category){
        return  requestService.selectSomethingFinance(nameGroup,category);
    }

  /*  @RequestMapping("/request7")
    List<Agency> selectSomethingAgencyTour(){
        return  requestService.selectSomethingAgencyTour();
    }*/
  @RequestMapping("/request4")
  List<Agency> selectSomethingInfo(@RequestParam String firstName,@RequestParam String lastName){
      return  requestService.selectSomethingInfo(firstName,lastName);
  }
    @RequestMapping("/request15")
    List<Agency> selectSomethingAgencyJour(@RequestParam String nameJourney){
        return  requestService.selectSomethingAgencyJour(nameJourney);
    }
    @RequestMapping("/request6")
    List<Agency> selectSomethingList(@RequestParam(value = "date1", required = true)
                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date1,
                                     @RequestParam(value = "date2", required = true)
                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date2){
        return  requestService.selectSomethingList(date1,date2);
    }
    @RequestMapping("/request17")
    List<AmountAgency> selectAmountAgency(){
        return  requestService.selectAmountAgency();
    }
    @RequestMapping("/request18")
    List<GroupTourist> selectTourist(@RequestParam String nameGroup){
        return  requestService.selectTourist(nameGroup);
    }
    @RequestMapping("/request19")
    List<AmountAgency> selectAmountAgencyHotel(){
        return  requestService.selectAmountAgencyHotel();
    }

    @RequestMapping("/request11")
    List<Agency> selectAmountAir(){
        return  requestService.selectAmountAir();
    }

}
