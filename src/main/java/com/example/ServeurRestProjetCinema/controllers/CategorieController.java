package com.example.ServeurRestProjetCinema.controllers;

import com.example.ServeurRestProjetCinema.models.Categorie;
import com.example.ServeurRestProjetCinema.repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Categorie")
public class CategorieController {

    @Autowired
    CategorieRepository categorieRepository;

    // Get all cat
    @GetMapping("/liste")
    public List<Categorie> getListeCategorie(){
        return categorieRepository.findAll();
    }

    // Get one cat
    @GetMapping("/get")
    public ResponseEntity<Categorie> getCat(@RequestParam(value = "code", required = true) String code){
        Categorie cat = categorieRepository.findOne(code);
        if (cat == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(cat);
    }

    //Add cat
    @PostMapping("/ajout")
    public Categorie ajouterCat (@Valid @RequestBody Categorie cat){
        return categorieRepository.save(cat);
    }

    //Update cat
    @PutMapping("/modif")
    public ResponseEntity<Categorie> modifCat(@RequestParam(value = "code") String code,
                                              @Valid @RequestBody Categorie catDetail){
        Categorie categorie = categorieRepository.findOne(code);
        if (categorie == null){
            return ResponseEntity.notFound().build();
        }
        categorie.setLibelle(catDetail.getLibelle());

        Categorie modifCat = categorieRepository.save(categorie);
        return ResponseEntity.ok(modifCat);
    }

    //Delete cat
    @DeleteMapping("/supp")
    public ResponseEntity<Categorie> suppCat(@RequestParam(value = "code") String code){
        Categorie cat = categorieRepository.findOne(code);
        if (cat == null){
            return ResponseEntity.notFound().build();
        }
        categorieRepository.delete(cat);
        return ResponseEntity.ok(cat);

    }
}
