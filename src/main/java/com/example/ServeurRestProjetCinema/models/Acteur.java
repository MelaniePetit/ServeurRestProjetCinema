package com.example.ServeurRestProjetCinema.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.text.SimpleDateFormat;

@Entity
@Table(name = "acteur")
public class Acteur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdAct")
    private int id;

    @NotBlank
    @Column(name = "NomAct")
    private String nom;

    @NotBlank
    @Column(name = "PrenAct")
    private String prenom;

    @NotBlank
    @Column(name = "DateNaissAct")
    private Date dateNaiss;

    @Column(name = "DateDecesAct")
    private Date dateDeces;

    public Acteur() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public Date getDateDeces() {
        return dateDeces;
    }

    public void setDateDeces(Date dateDeces) {
        this.dateDeces = dateDeces;
    }
}

