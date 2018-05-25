package com.vovaluck.lab5db.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "grouptourist")
@EntityListeners(AuditingEntityListener.class)
public class GroupTourist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_group_tourist")
    private int idGroupTourist;

    //@Column(nullable = false)
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "sur_name")
    private String surName;

    @Column(name = "passport_data")
    private LocalDate passportData;

    @Column(name = "gender")
    private String gender;

    @Column(name = "kids")
    private String kids;

    @Column(name = "hotel")
    private String hotel;

    @Column(name = "old")
    private int old;

    @Column(name = "category")
    private String category;

    @Column(name = "name_group")
    private String nameGroup;

    @Column(name = "dob")
    private LocalDate dateOfBirth;




    public GroupTourist() {
    }


    public GroupTourist(String firstName, String lastName, String surName, LocalDate passportData, String gender, String kids, String hotel, int old, String category, String nameGroup, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.surName = surName;
        this.passportData = passportData;
        this.gender = gender;
        this.kids = kids;
        this.hotel = hotel;
        this.old = old;
        this.category = category;
        this.nameGroup = nameGroup;
        this.dateOfBirth = dateOfBirth;
    }

    public int getIdGroupTourist() {
        return idGroupTourist;
    }

    public void setIdGroupTourist(int idGroupTourist) {
        this.idGroupTourist = idGroupTourist;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public LocalDate getPassportData() {
        return passportData;
    }

    public void setPassportData(LocalDate passportData) {
        this.passportData = passportData;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getKids() {
        return kids;
    }

    public void setKids(String kids) {
        this.kids = kids;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
