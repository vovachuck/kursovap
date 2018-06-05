package com.vovaluck.lab5db.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "agency")
@EntityListeners(AuditingEntityListener.class)
public class Agency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agency")
    private int idAgency;

    //@Column(nullable = false)



    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "grouptourist_id_group_tourist", insertable = false, updatable = false)
    private GroupTourist groupTourist;

    @Column(name = "grouptourist_id_group_tourist")
    private int grouptourist_idGroupTourist;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "airport_id_airport", insertable = false, updatable = false)
    private Airport airport;

    @Column(name = "airport_id_airport")
    private int airport_idAirport;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tour_id_tour", insertable = false, updatable = false)
    private Tour tour;

    @Column(name = "tour_id_tour",nullable = true)

    private int tour_idTour;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "storage_id_storage", insertable = false, updatable = false)
    private Storage storage;

    @Column(name = "storage_id_storage",nullable = true)

    private int storage_idStorage;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "financereport_id_finance_report", insertable = false, updatable = false)
    private FinanceReport financeReport;

    @Column(name = "financereport_id_finance_report")
    private int financereport_idFinanceReport;

    @Column(name = "price_all_tour")
    private double priceAllTour;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hotel_id_hotel", insertable = false, updatable = false)
    private Hotel hotel;

    @Column(name = "hotel_id_hotel")
    private int hotel_id_hotel;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id_country", insertable = false, updatable = false)
    private Country country;

    @Column(name = "country_id_country")
    private int country_id_country;
    @Transient
    long count;


    public Agency() {
    }


    public Agency(GroupTourist groupTourist, int grouptourist_idGroupTourist, Airport airport, int airport_idAirport, Tour tour, Integer tour_idTour, Storage storage, Integer storage_idStorage, FinanceReport financeReport, int financereport_idFinanceReport, double priceAllTour, Hotel hotel, int hotel_id_hotel, Country country, int country_id_country, long count) {
        this.groupTourist = groupTourist;
        this.grouptourist_idGroupTourist = grouptourist_idGroupTourist;
        this.airport = airport;
        this.airport_idAirport = airport_idAirport;
        this.tour = tour;
        this.tour_idTour = tour_idTour;
        this.storage = storage;
        this.storage_idStorage = storage_idStorage;
        this.financeReport = financeReport;
        this.financereport_idFinanceReport = financereport_idFinanceReport;
        this.priceAllTour = priceAllTour;
        this.hotel = hotel;
        this.hotel_id_hotel = hotel_id_hotel;
        this.country = country;
        this.country_id_country = country_id_country;
        this.count=count;
    }



    public int getIdAgency() {
        return idAgency;
    }

    public void setIdAgency(int idAgency) {
        this.idAgency = idAgency;
    }

    public GroupTourist getGroupTourist() {
        return groupTourist;
    }

    public void setGroupTourist(GroupTourist groupTourist) {
        this.groupTourist = groupTourist;
    }

    public int getGrouptourist_idGroupTourist() {
        return grouptourist_idGroupTourist;
    }

    public void setGrouptourist_idGroupTourist(int grouptourist_idGroupTourist) {
        this.grouptourist_idGroupTourist = grouptourist_idGroupTourist;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public int getAirport_idAirport() {
        return airport_idAirport;
    }

    public void setAirport_idAirport(int airport_idAirport) {
        this.airport_idAirport = airport_idAirport;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public Integer getTour_idTour() {
        return tour_idTour;
    }

    public void setTour_idTour(int tour_idTour) {
        this.tour_idTour = tour_idTour;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Integer getStorage_idStorage() {
        return storage_idStorage;
    }

    public void setStorage_idStorage(int storage_idStorage) {
        this.storage_idStorage = storage_idStorage;
    }

    public FinanceReport getFinanceReport() {
        return financeReport;
    }

    public void setFinanceReport(FinanceReport financeReport) {
        this.financeReport = financeReport;
    }

    public int getFinancereport_idFinanceReport() {
        return financereport_idFinanceReport;
    }

    public void setFinancereport_idFinanceReport(int financereport_idFinanceReport) {
        this.financereport_idFinanceReport = financereport_idFinanceReport;
    }

    public double getPriceAllTour() {
        return priceAllTour;
    }

    public void setPriceAllTour(double priceAllTour) {
        this.priceAllTour = priceAllTour;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public int getHotel_id_hotel() {
        return hotel_id_hotel;
    }

    public void setHotel_id_hotel(int hotel_id_hotel) {
        this.hotel_id_hotel = hotel_id_hotel;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public int getCountry_id_country() {
        return country_id_country;
    }

    public void setCountry_id_country(int country_id_country) {
        this.country_id_country = country_id_country;
    }


    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}