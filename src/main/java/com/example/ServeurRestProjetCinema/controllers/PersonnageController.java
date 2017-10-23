package com.example.ServeurRestProjetCinema.controllers;

import com.example.ServeurRestProjetCinema.models.Acteur;
import com.example.ServeurRestProjetCinema.models.Film;
import com.example.ServeurRestProjetCinema.models.Personnage;
import com.example.ServeurRestProjetCinema.repositories.ActeurRepository;
import com.example.ServeurRestProjetCinema.repositories.FilmRepository;
import com.example.ServeurRestProjetCinema.repositories.PersonnageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Personnage")
public class PersonnageController {

    @Autowired
    PersonnageRepository personnageRepository;
    @Autowired
    FilmRepository filmRepository;
    @Autowired
    ActeurRepository acteurRepository;

    // Get tous les personnages
    @GetMapping("/liste")
    public List<Personnage> getListeReal(){
        return personnageRepository.findAll();
    }

    // Get un personnage
    @GetMapping("/{id}")
    public ResponseEntity<Personnage> getReal(@PathVariable(name = "id") int id){
        Personnage personnage = personnageRepository.findOne(id);
        if (personnage == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(personnage);
    }

    //Get pero d'un film
    @GetMapping("/liste/film/{id}")
    public List<Personnage> findByFilm(@PathVariable(name = "id") int idFilm){
        Film film = filmRepository.findOne(idFilm);
        if (film == null){
            return null;
        }
        return personnageRepository.findAllByFilm(film);
    }

    //Get perso d'un acteur
    @GetMapping("/liste/acteur/{id]")
    public List<Personnage> findByActeur(@PathVariable(name = "id") int idAct){
        Acteur acteur =  acteurRepository.findOne(idAct);
        if (acteur == null){
            return null;
        }
        return personnageRepository.findAllByActeur(acteur);
    }


    // Delete perso
    @DeleteMapping("/{id}")
    public ResponseEntity<Personnage> suppReal(@PathVariable(name = "id") int id){
        Personnage personnage = personnageRepository.findOne(id);
        if (personnage == null){
            return ResponseEntity.notFound().build();
        }

        personnageRepository.delete(personnage);
        return ResponseEntity.ok(personnage);
    }
}
