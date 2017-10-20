package com.example.ServeurRestProjetCinema.repositories;

import com.example.ServeurRestProjetCinema.models.Categorie;
import com.example.ServeurRestProjetCinema.models.Film;
import com.example.ServeurRestProjetCinema.models.Realisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {

    public List<Film> findFilmsByRealisateur(Realisateur realisateur);

    public List<Film> findFilmsByCategorie(Categorie categorie);


}
