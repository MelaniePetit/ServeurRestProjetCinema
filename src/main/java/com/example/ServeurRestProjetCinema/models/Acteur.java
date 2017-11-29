package com.example.ServeurRestProjetCinema.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

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

    @Column(name = "DateNaissAct")
    private Date dateNaiss;

    @Column(name = "DateDecesAct")
    private Date dateDeces;

    @JsonIgnore
    @OneToMany(mappedBy = "acteur")
    private List<Personnage> personnage;

    public Acteur() {
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
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

