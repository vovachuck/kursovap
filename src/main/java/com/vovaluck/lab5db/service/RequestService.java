package com.vovaluck.lab5db.service;

import com.vovaluck.lab5db.model.*;
import com.vovaluck.lab5db.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class RequestService implements IRequest {
    @Autowired
    GroupTouristRepository groupTouristRepository;
    @Autowired
    AgencyRepository agencyRepository;
    @Autowired
    StorageRepository storageRepository;
    @Autowired
    FinanceReportRepository financeReportRepository;
    @Autowired
    AirportRepository airportRepository;
    @Override
    public List<GroupTourist> selectSomething(String nameCountry){
        return groupTouristRepository.selectSomething(nameCountry);
    }

    @Override
    public List<GroupTourist> selectSomethingHotel(String hotelName) {
        return groupTouristRepository.selectSomethingHotel(hotelName);
    }

    @Override
    public List<GroupTourist> selectSomethingCountry(String category,String countryArrival,LocalDate date1,LocalDate date2) {
        return groupTouristRepository.selectSomethingCountry(category,countryArrival,date1,date2);
    }

    @Override
    public List<GroupTourist> selectSomethingCountryAll(String countryArrival, LocalDate date1, LocalDate date2) {
        return groupTouristRepository.selectSomethingCountryAll(countryArrival,date1,date2);
    }

    @Override
    public List<Agency> selectSomethingAgency(LocalDate date1, LocalDate date2) {
        return agencyRepository.selectSomethingAgency(date1,date2);
    }

    @Override
    public List<Storage> selectSomethingStore(LocalDate date1, LocalDate date2) {
        return storageRepository.selectSomethingStore(date1,date2);
    }

    @Override
    public List<FinanceReport> selectSomethingFinance(String nameGroup, String category) {
        return financeReportRepository.selectSomethingFinance(nameGroup,category);
    }

    @Override
    public List<Agency> selectSomethingInfo(String firstName, String lastName) {
        return agencyRepository.selectSomethingInfo(firstName,lastName);
    }

    @Override
    public List<Agency> selectSomethingAgencyJour(String nameJourney) {
        return agencyRepository.selectSomethingAgencyJour(nameJourney);
    }

    @Override
    public List<Agency> selectSomethingList(LocalDate date1, LocalDate date2) {
        return agencyRepository.selectSomethingList(date1,date2);
    }


    /* @Override
     public List<Agency> selectSomethingAgencyTour() {
         return agencyRepository.selectSomethingAgencyTour();
     }*/
    /*@Override
    public List<Agency> selectSomethingAgencyFinance(LocalDate date1, LocalDate date2) {
        return agencyRepository.selectSomethingAgencyFinance(date1,date2);
    }*/
    public List<AmountAgency> selectAmountAgency(){
        List<Agency> agencies=agencyRepository.selectAgency();
        List<Long> amount=agencyRepository.selectAmount();
        List<AmountAgency> list=new ArrayList<>();
        for (int i = 0; i < amount.size(); i++) {
            list.add(new AmountAgency(amount.get(i),agencies.get(i)));


        }
        return  list;
    }

    @Override
    public List<GroupTourist> selectTourist(String nameGroup) {
        return groupTouristRepository.selectTourist(nameGroup);
    }
    public List<AmountAgency> selectAmountAgencyHotel(){
        List<Agency> agencies=agencyRepository.selectAgencyHotel();
        List<Long> amount=agencyRepository.selectAmountHotel();
        List<AmountAgency> list=new ArrayList<>();
        for (int i = 0; i < amount.size(); i++) {
            list.add(new AmountAgency(amount.get(i),agencies.get(i)));


        }
        return  list;
    }

    @Override
    public List<Agency> selectAmountAir() {
        return agencyRepository.selectAmountAir();
    }

    @Override
    public List<Agency> selectTourTourist(String nameTour) {
        return agencyRepository.selectTourTourist(nameTour);
    }

    @Override
    public List<Agency> selectVisa(LocalDate date1) {
        return agencyRepository.selectVisa(date1);
    }

    @Override
    public List<Airport> selectAir(String nameJourney) {
        return airportRepository.selectAir(nameJourney);
    }

    @Override
    public List<Airport> selectAirJour(LocalDate date1) {
        return airportRepository.selectAirJour(date1);
    }

    @Override
    public List<GroupTourist> selectTouristCategory(String category) {
        return groupTouristRepository.selectTouristCategory(category);
    }

    @Override
    public List<Agency> selectSomethingInfoTourist(String nameGroup) {
        return agencyRepository.selectSomethingInfoTourist(nameGroup);
    }


}
