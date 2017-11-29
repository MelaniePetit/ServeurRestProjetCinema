package com.example.ServeurRestProjetCinema.controllers;

import com.example.ServeurRestProjetCinema.models.Realisateur;
import com.example.ServeurRestProjetCinema.repositories.RealisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Realisateur")
public class RealisateurController {

    @Autowired
    RealisateurRepository realisateurRepository;

    // Get tous les realisateur
    @GetMapping("/liste")
    public List<Realisateur> getListeReal(){
        return realisateurRepository.findAll();
    }

    // Get un realisateur
    @GetMapping("/{id}")
    public ResponseEntity<Realisateur> getReal(@PathVariable(name = "id") int id){
        Realisateur realisateur = realisateurRepository.findOne(id);
        if (realisateur == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(realisateur);
    }

    // Creat realisateur
    @PostMapping("/ajout")
    public Realisateur ajoutReal(@Valid @RequestBody Realisateur realisateur){
        return realisateurRepository.save(realisateur);
    }

    // Update realisateur
    @PutMapping("/{id}")
    public ResponseEntity<Realisateur> modifReal(@PathVariable(name = "id") int id,
                                                 @RequestBody Realisateur realDetail){
        Realisateur realisateur = realisateurRepository.findOne(id);
        if (realisateur == null){
            return ResponseEntity.notFound().build();
        }

        realisateur.setNom(realDetail.getNom());
        realisateur.setPrenom((realDetail.getPrenom()));

        Realisateur updateReal = realisateurRepository.save(realisateur);
        return ResponseEntity.ok(updateReal);
    }

    // Delete realisateur
    @DeleteMapping("/{id}")
    public ResponseEntity<Realisateur> suppReal(@PathVariable(name = "id") int id){
        Realisateur realisateur = realisateurRepository.findOne(id);
        if (realisateur == null){
            return ResponseEntity.notFound().build();
        }

        realisateurRepository.delete(realisateur);
        return ResponseEntity.ok(realisateur);
    }
}


