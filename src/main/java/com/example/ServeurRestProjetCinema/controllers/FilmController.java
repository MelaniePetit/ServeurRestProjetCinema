package com.example.ServeurRestProjetCinema.controllers;

import com.example.ServeurRestProjetCinema.models.Categorie;
import com.example.ServeurRestProjetCinema.models.Film;
import com.example.ServeurRestProjetCinema.models.Realisateur;
import com.example.ServeurRestProjetCinema.repositories.CategorieRepository;
import com.example.ServeurRestProjetCinema.repositories.FilmRepository;
import com.example.ServeurRestProjetCinema.repositories.RealisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Film")
public class FilmController {

    @Autowired
    FilmRepository filmRepository;
    @Autowired
    RealisateurRepository realisateurRepository;
    @Autowired
    CategorieRepository categorieRepository;

    // Get tous les films
    @GetMapping("/liste")
    public List<Film> getListFilm(){
        return filmRepository.findAll();
    }

    // Get un film
    @GetMapping("/{id}")
    public ResponseEntity<Film> getFilm(@PathVariable(name = "id") int id){
        Film film = filmRepository.findOne(id);
        if (film == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(film);
    }

    //Get films d'un realisateur
    @GetMapping("/liste/{id}")
    public List<Film> getFilmBy(@PathVariable(name = "id") int idReal){
        Realisateur realisateur = realisateurRepository.findOne(idReal);
        if (realisateur == null){
            return null;
        }
        return filmRepository.findFilmsByRealisateur(realisateur);
    }

    //Get films d'une categorie
    @GetMapping("/liste/cat")
    public List<Film> getFilmBy(@RequestParam(name = "code") String codeCat){
        Categorie categorie =  categorieRepository.findOne(codeCat);
        if (categorie == null){
            return null;
        }
        return filmRepository.findFilmsByCategorie(categorie);
    }

    // Creat film
    @PostMapping("/ajout")
    public Film ajoutFilm(@Valid @RequestBody Film film){
        return filmRepository.save(film);
    }

    // Update film
    @PutMapping("/{id}")
    public ResponseEntity<Film> modifFilm(@PathVariable(name = "id") int id,
                                                 @RequestBody Film filmDetail){
        Film film = filmRepository.findOne(id);
        if (film == null){
            return ResponseEntity.notFound().build();
        }

        film.setTitre(filmDetail.getTitre());
        film.setBudget(filmDetail.getBudget());
        film.setDateSortie(filmDetail.getDateSortie());
        film.setDuree(filmDetail.getDuree());
        film.setMontantRecette(filmDetail.getMontantRecette());
        film.setCategorie(filmDetail.getCategorie());
        film.setRealisateur(filmDetail.getRealisateur());

        Film updateFilm = filmRepository.save(film);
        return ResponseEntity.ok(updateFilm);
    }

    // Delete film
    @DeleteMapping("/{id}")
    public ResponseEntity<Film> suppFilm(@PathVariable(name = "id") int id){
        Film film = filmRepository.findOne(id);
        if (film == null){
            return ResponseEntity.notFound().build();
        }

        filmRepository.delete(film);
        return ResponseEntity.ok(film);
    }
}
