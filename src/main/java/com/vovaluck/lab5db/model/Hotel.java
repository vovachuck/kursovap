package com.vovaluck.lab5db.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "hotel")
@EntityListeners(AuditingEntityListener.class)
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hotel")
    private int idHotel;

    //@Column(nullable = false)
    @Column(name = "number_available")
    private int numberAvailable;

    @Column(name = "hotel_name")
    private String hotelName;

    @Column(name = "date_eviction")
    private LocalDate date_eviction;
    @Column(name = "number_occupied")
    private int number_occupied;


    public Hotel() {
    }

    public Hotel(int numberAvailable, String hotelName, LocalDate date_eviction, int number_occupied) {
        this.numberAvailable = numberAvailable;
        this.hotelName = hotelName;
        this.date_eviction = date_eviction;
        this.number_occupied = number_occupied;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public int getNumberAvailable() {
        return numberAvailable;
    }

    public void setNumberAvailable(int numberAvailable) {
        this.numberAvailable = numberAvailable;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }


    public LocalDate getDate_eviction() {
        return date_eviction;
    }

    public void setDate_eviction(LocalDate date_eviction) {
        this.date_eviction = date_eviction;
    }

    public int getNumber_occupied() {
        return number_occupied;
    }

    public void setNumber_occupied(int number_occupied) {
        this.number_occupied = number_occupied;
    }
}
  /*
    spring.jpa.hibernate.ddl-auto=create
spring.datasource.url=jdbc:mysql://localhost:3306/lab5db
spring.datasource.username=root
spring.datasource.password=root
    */

