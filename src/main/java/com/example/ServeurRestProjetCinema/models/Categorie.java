package com.example.ServeurRestProjetCinema.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Table(name = "categorie")
public class Categorie {

    @Id
    @Column(name = "CodeCat")
    private String code;

    @NotBlank
    @Column(name = "LibelleCat")
    private String libbele;

    public Categorie() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibbele() {
        return libbele;
    }

    public void setLibbele(String libbele) {
        this.libbele = libbele;
    }
}
