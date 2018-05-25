package com.vovaluck.lab5db.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "financereport")
@EntityListeners(AuditingEntityListener.class)
public class FinanceReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFinanceReport")
    private int idFinanceReport;

    //@Column(nullable = false)
    @Column(name = "costHotel")
    private double costHotel;

    @Column(name = "transportation")
    private double transportation;

    @Column(name = "unforeseenExpenses")
    private double unforeseenExpenses;

    @Column(name = "settlementsAirport")
    private double settlementsAirport;

    public FinanceReport() {
    }

    public FinanceReport(double costHotel, double transportation, double unforeseenExpenses, double settlementsAirport) {
        this.costHotel = costHotel;
        this.transportation = transportation;
        this.unforeseenExpenses = unforeseenExpenses;
        this.settlementsAirport = settlementsAirport;
    }

    public int getIdFinanceReport() {
        return idFinanceReport;
    }

    public void setIdFinanceReport(int idFinanceReport) {
        this.idFinanceReport = idFinanceReport;
    }

    public double getCostHotel() {
        return costHotel;
    }

    public void setCostHotel(double costHotel) {
        this.costHotel = costHotel;
    }

    public double getTransportation() {
        return transportation;
    }

    public void setTransportation(double transportation) {
        this.transportation = transportation;
    }

    public double getUnforeseenExpenses() {
        return unforeseenExpenses;
    }

    public void setUnforeseenExpenses(double unforeseenExpenses) {
        this.unforeseenExpenses = unforeseenExpenses;
    }

    public double getSettlementsAirport() {
        return settlementsAirport;
    }

    public void setSettlementsAirport(double settlementsAirport) {
        this.settlementsAirport = settlementsAirport;
    }
}
