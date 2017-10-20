package com.example.ServeurRestProjetCinema.repositories;

import com.example.ServeurRestProjetCinema.models.Realisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealisateurRepository extends JpaRepository<Realisateur, Integer> {
}
