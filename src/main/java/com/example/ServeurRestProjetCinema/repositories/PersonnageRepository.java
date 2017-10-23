package com.example.ServeurRestProjetCinema.repositories;

import com.example.ServeurRestProjetCinema.models.Acteur;
import com.example.ServeurRestProjetCinema.models.Film;
import com.example.ServeurRestProjetCinema.models.Personnage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonnageRepository extends JpaRepository<Personnage, Integer> {

    public List<Personnage> findAllByFilm(Film film);

    public List<Personnage> findAllByActeur(Acteur acteur);
}
