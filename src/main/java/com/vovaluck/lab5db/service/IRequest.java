package com.vovaluck.lab5db.service;

import com.vovaluck.lab5db.model.*;
import com.vovaluck.lab5db.repository.GroupTouristRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IRequest {
    List<GroupTourist> selectSomething(String nameCountry);
    List<GroupTourist> selectSomethingHotel(String hotelName);
    List<GroupTourist> selectSomethingCountry(String category,String countryArrival,LocalDate date1,LocalDate date2);
    List<GroupTourist> selectSomethingCountryAll(String countryArrival,LocalDate date1,LocalDate date2);
    List<Agency> selectSomethingAgency(LocalDate date1, LocalDate date2);
  /*  List<Agency> selectSomethingAgencyFinance(LocalDate date1, LocalDate date2);*/
    List<Storage> selectSomethingStore(LocalDate date1,LocalDate date2);
    List<FinanceReport> selectSomethingFinance(String nameGroup,String category);
    List<Agency> selectSomethingInfo(String firstName,String lastName);
    List<Agency> selectSomethingAgencyJour(String nameJourney);
    List<Agency> selectSomethingList(LocalDate date1,LocalDate date2);
    List<AmountAgency> selectAmountAgency ();
    List<GroupTourist> selectTourist(String nameGroup);
    List<AmountAgency> selectAmountAgencyHotel();



}
