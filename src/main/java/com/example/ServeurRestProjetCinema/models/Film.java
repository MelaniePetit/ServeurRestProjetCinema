package com.example.ServeurRestProjetCinema.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "film")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdFilm")
    private int id;

    @Column(name = "TitreFilm")
    private String titre;

    @Column(name = "DureeFilm")
    private int duree;

    @Column(name = "DateSortieFilm")
    private Date dateSortie;


    @Column(name = "BudgetFilm")
    private int budget;

    @Column(name = "MontantRecetteFilm")
    private int montantRecette;

    @ManyToOne
    @JoinColumn(name = "IdReal")
    private Realisateur realisateur;

    @ManyToOne
    @JoinColumn(name = "CodeCat")
    private Categorie categorie;

    @JsonIgnore
    @OneToMany(mappedBy = "film")
    private List<Personnage> personnage;


    public Film() {
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getMontantRecette() {
        return montantRecette;
    }

    public void setMontantRecette(int montantRecette) {
        this.montantRecette = montantRecette;
    }

    public Realisateur getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(Realisateur realisateur) {
        this.realisateur = realisateur;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<Personnage> getPersonnage() {
        return personnage;
    }

    public void setPersonnage(List<Personnage> personnage) {
        this.personnage = personnage;
    }
}
