package com.example.ServeurRestProjetCinema.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.List;

@Entity
public class Personnage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdPers")
    private int id;

    @NotBlank
    @Column(name = "NomPers")
    private String nom;

    @ManyToOne
    @JoinColumn(name = "IdAct")
    private Acteur acteur;

    @ManyToOne
    @JoinColumn(name = "IdFilm")
    private Film film;

    public Personnage() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public Acteur getActeur() {
        return acteur;
    }

    public void setActeur(Acteur acteur) {
        this.acteur = acteur;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}
