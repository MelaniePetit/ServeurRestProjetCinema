package com.example.ServeurRestProjetCinema.repositories;

import com.example.ServeurRestProjetCinema.models.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, String> {
}
