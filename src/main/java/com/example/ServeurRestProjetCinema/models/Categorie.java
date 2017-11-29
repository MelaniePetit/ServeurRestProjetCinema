package com.example.ServeurRestProjetCinema.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "categorie")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "code")
public class Categorie {

    @Id
    @Column(name = "CodeCat")
    private String code;

    @NotBlank
    @Column(name = "LibelleCat")
    private String libelle;

    @JsonIgnore
    @OneToMany(mappedBy = "categorie")
    private Collection<Film> films;

    public Categorie() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Collection<Film> getFilms() {
        return films;
    }

    public void setFilms(Collection<Film> films) {
        this.films = films;
    }
}
