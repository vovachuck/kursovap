package com.vovaluck.lab5db.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "storage")
@EntityListeners(AuditingEntityListener.class)
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idStorage",nullable = true)
    private Integer idStorage;

    //@Column(nullable = false)
    @Column(name = "marking")
    private String marking;

    @Column(name = "weight")
    private double weight;

    @Column(name = "datePack")
    private LocalDate datePack;

    @Column(name = "airplaneClass")
    private String airplaneClass;

    @Column(name = "numbPlacesCargo")
    private int numbPlacesCargo;

    @Column(name = "departureDateCargo")
    private LocalDate departureDateCargo;

    @Column(name = "arrivalDateCargo")
    private LocalDate arrivalDateCargo;

    @Column(name = "priceStoreCargo")
    private double priceStoreCargo;





    public Storage() {
    }


    public Storage(String marking, double weight, LocalDate datePack, String airplaneClass, int numbPlacesCargo, LocalDate departureDateCargo, LocalDate arrivalDateCargo, double priceStoreCargo) {
        this.marking = marking;
        this.weight = weight;
        this.datePack = datePack;
        this.airplaneClass = airplaneClass;
        this.numbPlacesCargo = numbPlacesCargo;
        this.departureDateCargo = departureDateCargo;
        this.arrivalDateCargo = arrivalDateCargo;
        this.priceStoreCargo = priceStoreCargo;
    }

    public int getIdStorage() {
        return idStorage;
    }

    public void setIdStorage(int idStorage) {
        this.idStorage = idStorage;
    }

    public String getMarking() {
        return marking;
    }

    public void setMarking(String marking) {
        this.marking = marking;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public LocalDate getDatePack() {
        return datePack;
    }

    public void setDatePack(LocalDate datePack) {
        this.datePack = datePack;
    }

    public String getAirplaneClass() {
        return airplaneClass;
    }

    public void setAirplaneClass(String airplaneClass) {
        this.airplaneClass = airplaneClass;
    }

    public int getNumbPlacesCargo() {
        return numbPlacesCargo;
    }

    public void setNumbPlacesCargo(int numbPlacesCargo) {
        this.numbPlacesCargo = numbPlacesCargo;
    }

    public LocalDate getDepartureDateCargo() {
        return departureDateCargo;
    }

    public void setDepartureDateCargo(LocalDate departureDateCargo) {
        this.departureDateCargo = departureDateCargo;
    }

    public LocalDate getArrivalDateCargo() {
        return arrivalDateCargo;
    }

    public void setArrivalDateCargo(LocalDate arrivalDateCargo) {
        this.arrivalDateCargo = arrivalDateCargo;
    }

    public double getPriceStoreCargo() {
        return priceStoreCargo;
    }

    public void setPriceStoreCargo(double priceStoreCargo) {
        this.priceStoreCargo = priceStoreCargo;
    }
}
