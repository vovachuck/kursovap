package com.vovaluck.lab5db.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "customs")
@EntityListeners(AuditingEntityListener.class)
public class Customs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customs")
    private int idCustoms;

    //@Column(nullable = false)
    @Column(name = "nationality")
    private String nationality;

    @Column(name = "type_visa")
    private String typeVisa;

    @Column(name = "date_end")
    private LocalDate dateEnd;
    @Column(name = "date_start")
    private LocalDate dateStart;

    @Column(name = "priceVIsa")
    private double priceVIsa;
    @JsonIgnore
    @OneToMany(mappedBy = "customs",cascade = CascadeType.REMOVE)
    private List<Country> country;





    public Customs(String nationality, String typeVisa, LocalDate dateEnd, LocalDate dateStart, double priceVIsa, List<Country> airport) {
        this.nationality = nationality;
        this.typeVisa = typeVisa;
        this.dateEnd = dateEnd;
        this.dateStart = dateStart;
        this.priceVIsa = priceVIsa;

        this.country = airport;
    }
    public Customs() {
    }
    public int getIdCustoms() {
        return idCustoms;
    }

    public void setIdCustoms(int idCustoms) {
        this.idCustoms = idCustoms;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getTypeVisa() {
        return typeVisa;
    }

    public void setTypeVisa(String typeVisa) {
        this.typeVisa = typeVisa;
    }



    public double getPriceVIsa() {
        return priceVIsa;
    }

    public void setPriceVIsa(double priceVIsa) {
        this.priceVIsa = priceVIsa;
    }


    public List<Country> getCountry() {
        return country;
    }

    public void setCountry(List<Country> country) {
        this.country = country;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }
}
