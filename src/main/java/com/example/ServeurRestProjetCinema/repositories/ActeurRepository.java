package com.example.ServeurRestProjetCinema.repositories;

import com.example.ServeurRestProjetCinema.models.Acteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActeurRepository extends JpaRepository<Acteur, Integer> {
}
