package com.example.ServeurRestProjetCinema.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "realisateur")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
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

    @JsonIgnore
    @OneToMany(mappedBy = "realisateur")
    private Collection<Film> films;

    public Realisateur() {
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

    public Collection<Film> getFilms() {
        return films;
    }

    public void setFilms(Collection<Film> films) {
        this.films = films;
    }
}
