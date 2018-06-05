package com.vovaluck.lab5db.repository;

import com.vovaluck.lab5db.model.Agency;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AgencyRepository extends JpaRepository<Agency,Integer> {
    @Query("Select agency From Agency agency " +
            "inner join Hotel hotel on hotel.idHotel=agency.hotel_id_hotel " +
            "join Airport airport on airport.idAirport=agency.airport_idAirport "+
            "join GroupTourist groupTourist on groupTourist.idGroupTourist=agency.grouptourist_idGroupTourist "+
            "where airport.dateArrival between  :date1 and :date2")
    List<Agency> selectSomethingAgency(@Param("date1") LocalDate date1, @Param("date2") LocalDate date2);


    /*@Query("Select sum(finance.costHotel),sum(finance.transportation), " +
            "sum(finance.unforeseenExpenses),sum(finance.settlementsAirport), " +
            "sum(tour.priceTour),sum(customs.priceVIsa),sum(storage.priceStoreCargo), " +
            "sum(agency.priceAllTour) " +
            "From Agency agency " +
            "inner join FinanceReport finance on finance.idFinanceReport=agency.financereport_idFinanceReport " +
            "join Country country on country.idCountry=agency.country_id_country "+
            "join Customs customs on customs.idCustoms=country.customs_idCustoms "+
            "join Airport airport on airport.idAirport=agency.airport_idAirport "+
            "join Storage storage on storage.idStorage=agency.storage_idStorage "+
            "join Tour tour on tour.idTour=agency.tour_idTour "+
            "where airport.dateArrival between  :date1 and :date2")
    List<Agency> selectSomethingAgencyFinance(@Param("date1") LocalDate date1, @Param("date2") LocalDate date2);*/

    /*@Query("Select DISTINCT NEW Agency(agency.idAgency, agency.grouptourist_idGroupTourist, agency.airport_idAirport, " +
            "agency.tour_idTour,agency.storage_idStorage,agency.financereport_idFinanceReport,agency.priceAllTour " +
            ",agency.hotel_id_hotel,agency.country_id_country, COUNT(agency))  From Agency agency " +
            "inner join Tour tour on tour.idTour=agency.tour_idTour " +
            "GROUP BY agency.tour_idTour")
    List<Agency> selectSomethingAgencyTour();*/

    @Query("Select agency From Agency agency " +
            "inner join Airport airport on airport.idAirport=agency.airport_idAirport "+
            "join GroupTourist groupTourist on groupTourist.idGroupTourist=agency.grouptourist_idGroupTourist "+
            "where airport.nameJourney Like :nameJourney")
    List<Agency> selectSomethingAgencyJour(@Param("nameJourney") String nameJourney);

    @Query("Select agency From Agency agency " +
            "inner join Airport airport on airport.idAirport=agency.airport_idAirport "+
            "join Storage storage on storage.idStorage=agency.storage_idStorage "+
            "join Tour tour on tour.idTour=agency.tour_idTour "+
            "inner join Hotel hotel on hotel.idHotel=agency.hotel_id_hotel "+
            "join GroupTourist groupTourist on groupTourist.idGroupTourist=agency.grouptourist_idGroupTourist "+
            "where groupTourist.firstName Like :firstName and groupTourist.lastName Like :lastName")
    List<Agency> selectSomethingInfo(@Param("firstName") String firstName,@Param("lastName") String lastName);

    @Query("Select agency From Agency agency " +
            "join Tour tour on tour.idTour=agency.tour_idTour "+
            "join GroupTourist groupTourist on groupTourist.idGroupTourist=agency.grouptourist_idGroupTourist "+
            "where tour.dateStartTour between  :date1 and :date2")
    List<Agency> selectSomethingList(@Param("date1") LocalDate date1, @Param("date2") LocalDate date2);
    @Query("select count(agency.airport_idAirport) from Agency agency " +
            " inner join Airport airport on airport.idAirport=agency.airport_idAirport " +
            " group by airport.nameJourney order by agency.airport_idAirport")
    List<Long>selectAmount();
    @Query("select agency from Agency agency inner join Airport airport on airport.idAirport=agency.airport_idAirport " +
            "group by airport.nameJourney order by agency.airport_idAirport")
    List<Agency> selectAgency();

    @Query("select count(agency.hotel_id_hotel) from Agency agency " +
            " inner join Hotel hotel on hotel.idHotel=agency.hotel_id_hotel " +
            " group by hotel.hotelName order by agency.hotel_id_hotel")
    List<Long>selectAmountHotel();
    @Query("select agency from Agency agency " +
            " inner join Hotel hotel on hotel.idHotel=agency.hotel_id_hotel " +
            " group by hotel.hotelName order by agency.hotel_id_hotel")
    List<Agency> selectAgencyHotel();

    @Query("select DISTINCT New Agency(groupTourist,agency.grouptourist_idGroupTourist,airport,agency.airport_idAirport,tour,agency.tour_idTour," +
            "storage,agency.storage_idStorage,finance,agency.financereport_idFinanceReport,agency.priceAllTour,hotel,agency.hotel_id_hotel," +
            "country,agency.country_id_country,count (agency.airport_idAirport)) from Agency agency " +
            "inner join Hotel hotel on hotel.idHotel=agency.hotel_id_hotel " +
            "join GroupTourist groupTourist on groupTourist.idGroupTourist=agency.grouptourist_idGroupTourist " +
            "inner join Airport airport on airport.idAirport=agency.airport_idAirport " +
            "join Tour tour on tour.idTour=agency.tour_idTour " +
            "join Storage storage on storage.idStorage=agency.storage_idStorage " +
            "join Country country on country.idCountry=agency.country_id_country " +
            "join FinanceReport finance on finance.idFinanceReport=agency.financereport_idFinanceReport " +
            "group by airport.nameJourney order by agency.airport_idAirport")
    List<Agency>selectAmountAir();

    //count(agency.hotel_id_hotel)


}