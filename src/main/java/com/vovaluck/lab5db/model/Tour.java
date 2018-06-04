package com.vovaluck.lab5db.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tour")
@EntityListeners(AuditingEntityListener.class)
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tour")
    private Integer idTour;

    //@Column(nullable = false)
    @Column(name = "name_tour",nullable = true)
    private String nameTour;

    @Column(name = "date_start_tour",nullable = true)
    private LocalDate dateStartTour;

    @Column(name = "date_end_tour",nullable = true)
    private LocalDate dateEndTour;

    @Column(name = "agency",nullable = true)
    private String agency;

    @Column(name = "pricetour",nullable = true)
    private double priceTour;





    public Tour() {
    }


    public Tour(String nameTour, LocalDate dateStartTour, LocalDate dateEndTour, String agency, double priceTour) {
        this.nameTour = nameTour;
        this.dateStartTour = dateStartTour;
        this.dateEndTour = dateEndTour;
        this.agency = agency;
        this.priceTour = priceTour;
    }

    public Integer getIdTour() {
        return idTour;
    }

    public void setIdTour(int idTour) {
        this.idTour = idTour;
    }

    public String getNameTour() {
        return nameTour;
    }

    public void setNameTour(String nameTour) {
        this.nameTour = nameTour;
    }

    public LocalDate getDateStartTour() {
        return dateStartTour;
    }

    public void setDateStartTour(LocalDate dateStartTour) {
        this.dateStartTour = dateStartTour;
    }

    public LocalDate getDateEndTour() {
        return dateEndTour;
    }

    public void setDateEndTour(LocalDate dateEndTour) {
        this.dateEndTour = dateEndTour;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public double getPriceTour() {
        return priceTour;
    }

    public void setPriceTour(double priceTour) {
        this.priceTour = priceTour;
    }
}
