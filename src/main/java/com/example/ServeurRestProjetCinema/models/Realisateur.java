package com.example.ServeurRestProjetCinema.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Table(name = "realisateur")
public class Realisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdReal")
    private int id;

    @NotBlank
    @Column(name = "NomReal")
    private String nom;

    @NotBlank
    @Column(name = "PrenReal")
    private String prenom;

    public Realisateur() {
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
}
