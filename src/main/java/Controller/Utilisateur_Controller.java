package Controller;

import Models.Utilisateur;
import Service.Utilisateur_service;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class Utilisateur_Controller {

    @Autowired
    private Utilisateur_service utilisateurService;

    @GetMapping
    public ResponseEntity<List<Utilisateur>> getall(){
        List<Utilisateur> utilisateurs= utilisateurService.findAll();
        return new ResponseEntity<>(utilisateurs, HttpStatus.OK);
    }
    @GetMapping("/{id")
    public ResponseEntity<Utilisateur> getByID(@PathVariable String id){
        Utilisateur utilisateur = utilisateurService.findByUsername(id);
        return utilisateur !=null ? new ResponseEntity<>(utilisateur, HttpStatus.OK): new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Utilisateur> createUtilisateur (@RequestBody Utilisateur utilisateur){
        Utilisateur createdUtilisateur = utilisateurService.createUser(utilisateur);
        return new ResponseEntity<>(createdUtilisateur, HttpStatus.CREATED);
    }

    @PutMapping("/{id")
    public ResponseEntity<Utilisateur> updateUtilisateur (@PathVariable String id, @RequestBody Utilisateur utilisateur){
        Utilisateur updatedUtilisateur = utilisateurService.updateUser(id, utilisateur);
        return updatedUtilisateur != null ? new ResponseEntity<>(updatedUtilisateur, HttpStatus.OK) :new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable String id) {
        if (!utilisateurService.existById(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
