package com.vovaluck.lab5db.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "country")
@EntityListeners(AuditingEntityListener.class)
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_country")
    private int idCountry;

    //@Column(nullable = false)
    @Column(name = "name_country")
    private String nameCountry;


    @ManyToOne
    @JoinColumn(name = "customs_id_customs",insertable = false,updatable = false)
    private Customs customs;
    @Column (name="customs_id_customs")
    private int customs_idCustoms;

    public Country(String nameCountry, Customs customs, int customs_idCustoms) {
        this.nameCountry = nameCountry;
        this.customs = customs;

        this.customs_idCustoms = customs_idCustoms;
    }

    public Country() {
    }


    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }


    public int getCustoms_idCustoms() {
        return customs_idCustoms;
    }

    public void setCustoms_idCustoms(int customs_idCustoms) {
        this.customs_idCustoms = customs_idCustoms;
    }

    public Customs getCustoms() {
        return customs;
    }

    public void setCustoms(Customs customs) {
        this.customs = customs;
    }
}