package com.vovaluck.lab5db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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

    @Column(name = "number_occupied")
    private LocalDate numberOccupied;


    public Hotel() {
    }

    public Hotel(int numberAvailable, String hotelName, LocalDate numberOccupied) {
        this.numberAvailable = numberAvailable;
        this.hotelName = hotelName;
        this.numberOccupied = numberOccupied;
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


    public LocalDate getNumberOccupied() {
        return numberOccupied;
    }

    public void setNumberOccupied(LocalDate numberOccupied) {
        this.numberOccupied = numberOccupied;
    }
}
  /*
    spring.jpa.hibernate.ddl-auto=create
spring.datasource.url=jdbc:mysql://localhost:3306/lab5db
spring.datasource.username=root
spring.datasource.password=root
    */

