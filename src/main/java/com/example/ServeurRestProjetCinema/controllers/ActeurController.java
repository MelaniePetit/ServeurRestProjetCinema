package com.example.ServeurRestProjetCinema.controllers;

import com.example.ServeurRestProjetCinema.models.Acteur;
import com.example.ServeurRestProjetCinema.repositories.ActeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Acteur")
public class ActeurController {

    @Autowired
    ActeurRepository acteurRepository;

    //Get all acteur
    @GetMapping("/liste")
    public List<Acteur> getListeActeurs(){
        return acteurRepository.findAll();
    }

    //Get un acteur via son id
    @GetMapping("/{id}")
    public ResponseEntity<Acteur> getActeur(@PathVariable(value = "id") int acteurId){
        Acteur acteur = acteurRepository.findOne(acteurId);
        if (acteur == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(acteur);
    }

    //Create un acteur
    @PostMapping("/new")
    public Acteur createActeur(@Valid @RequestBody Acteur acteur){
        return acteurRepository.save(acteur);
    }

    //Update un acteur via son id
    @PutMapping("/{id}")
    public ResponseEntity<Acteur> updateNote(@PathVariable(value = "id") int acteurId,
                                           @Valid @RequestBody Acteur acteurDetails) {
        Acteur acteur = acteurRepository.findOne(acteurId);
        if(acteur == null) {
            return ResponseEntity.notFound().build();
        }
        acteur.setNom(acteurDetails.getNom());
        acteur.setPrenom(acteurDetails.getPrenom());
        acteur.setDateNaiss(acteurDetails.getDateNaiss());
        acteur.setDateDeces(acteurDetails.getDateDeces());

        Acteur updatedNote = acteurRepository.save(acteur);
        return ResponseEntity.ok(updatedNote);
    }

    //Delete un acteur via son id
    @DeleteMapping("/{id}")
    public ResponseEntity<Acteur> deleteNote(@PathVariable(value = "id") int acteurId) {
        Acteur acteur = acteurRepository.findOne(acteurId);
        if(acteur == null) {
            return ResponseEntity.notFound().build();
        }

        acteurRepository.delete(acteur);
        return ResponseEntity.ok().build();
    }

}
