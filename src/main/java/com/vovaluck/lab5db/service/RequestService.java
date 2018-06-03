package com.vovaluck.lab5db.service;

import com.vovaluck.lab5db.model.*;
import com.vovaluck.lab5db.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    @Override
    public List<Agency> selectSomethingAgencyFinance(LocalDate date1, LocalDate date2) {
        return agencyRepository.selectSomethingAgencyFinance(date1,date2);
    }

}
