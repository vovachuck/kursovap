package com.vovaluck.lab5db.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "airport")
@EntityListeners(AuditingEntityListener.class)
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_airport")
    private int idAirport;

    //@Column(nullable = false)
    @Column(name = "date_arrival")
    private LocalDate dateArrival;

    @Column(name = "departure_date")
    private LocalDate departureDate;

    @Column(name = "name_journey")
    private String nameJourney;

    @Column(name = "numb_seats")
    private int numbSeats;

    @Column(name = "country_departure")
    private String countryDeparture;

    @Column(name = "country_arrival")
    private String countryArrival;

    @Column(name = "numb_vacant_seats")
    private int numbVacantSeats;






    public Airport() {
    }


    public Airport(LocalDate dateArrival, LocalDate departureDate, String nameJourney, int numbSeats, String countryDeparture, String countryArrival, int numbVacantSeats) {
        this.dateArrival = dateArrival;
        this.departureDate = departureDate;
        this.nameJourney = nameJourney;
        this.numbSeats = numbSeats;
        this.countryDeparture = countryDeparture;
        this.countryArrival = countryArrival;
        this.numbVacantSeats = numbVacantSeats;

    }

    public int getIdAirport() {
        return idAirport;
    }

    public void setIdAirport(int idAirport) {
        this.idAirport = idAirport;
    }

    public LocalDate getDateArrival() {
        return dateArrival;
    }

    public void setDateArrival(LocalDate dateArrival) {
        this.dateArrival = dateArrival;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public String getNameJourney() {
        return nameJourney;
    }

    public void setNameJourney(String nameJourney) {
        this.nameJourney = nameJourney;
    }

    public int getNumbSeats() {
        return numbSeats;
    }

    public void setNumbSeats(int numbSeats) {
        this.numbSeats = numbSeats;
    }

    public String getCountryDeparture() {
        return countryDeparture;
    }

    public void setCountryDeparture(String countryDeparture) {
        this.countryDeparture = countryDeparture;
    }

    public String getCountryArrival() {
        return countryArrival;
    }

    public void setCountryArrival(String countryArrival) {
        this.countryArrival = countryArrival;
    }

    public int getNumbVacantSeats() {
        return numbVacantSeats;
    }

    public void setNumbVacantSeats(int numbVacantSeats) {
        this.numbVacantSeats = numbVacantSeats;
    }


}
