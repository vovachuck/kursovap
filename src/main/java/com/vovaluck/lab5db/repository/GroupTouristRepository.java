package com.vovaluck.lab5db.repository;


import com.vovaluck.lab5db.model.GroupTourist;

import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface GroupTouristRepository extends JpaRepository<GroupTourist,Integer> {

    @Query("Select grouptourist From GroupTourist grouptourist " +
            "inner join Agency agency on agency.idAgency=grouptourist.idGroupTourist " +
            "join Country country on country.idCountry=agency.country_id_country " +
            "where country.nameCountry Like :nameCountry")
    List<GroupTourist> selectSomething(@Param("nameCountry") String nameCountry);

    @Query("Select grouptourist From GroupTourist grouptourist " +
            "inner join Agency agency on agency.idAgency=grouptourist.idGroupTourist " +
            "join Hotel hotel on hotel.idHotel=agency.hotel_id_hotel " +
            "where hotel.hotelName Like :hotelName")
    List<GroupTourist> selectSomethingHotel(@Param("hotelName") String hotelName);
    @Query("Select grouptourist From GroupTourist grouptourist " +
            "inner join Agency agency on agency.idAgency=grouptourist.idGroupTourist " +
            "join Airport airport on airport.idAirport=agency.airport_idAirport " +
            "where grouptourist.category Like :category and airport.countryArrival Like :countryArrival and airport.dateArrival between  :date1 and :date2 ")
    List<GroupTourist> selectSomethingCountry(@Param("category") String category,@Param("countryArrival") String countryArrival,@Param("date1") LocalDate date1, @Param("date2") LocalDate date2);

    @Query("Select grouptourist From GroupTourist grouptourist " +
            "inner join Agency agency on agency.idAgency=grouptourist.idGroupTourist " +
            "join Airport airport on airport.idAirport=agency.airport_idAirport " +
            "where airport.countryArrival Like :countryArrival and airport.dateArrival between  :date1 and :date2")
    List<GroupTourist> selectSomethingCountryAll(@Param("countryArrival") String countryArrival,@Param("date1") LocalDate date1, @Param("date2") LocalDate date2);




}
