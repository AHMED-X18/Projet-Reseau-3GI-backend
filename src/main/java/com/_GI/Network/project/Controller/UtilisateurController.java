package com._GI.Network.project.Controller;

import com._GI.Network.project.Models.Utilisateur;
import com._GI.Network.project.Service.UtilisateurService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

@RestController
@RequestMapping("/users")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    // Inscription d'un nouvel utilisateur
    @PostMapping(value = "/register", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Utilisateur> createUtilisateur(
            @RequestParam("nom") @NotBlank(message = "Le nom est requis") String nom,
            @RequestParam("login") @NotBlank(message = "Le login est requis") String login,
            @RequestParam("email") @NotBlank(message = "L'email est requis") @Email(message = "L'email doit être valide") String email,
            @RequestParam("password") @NotBlank(message = "Le mot de passe est requis") String password,
            @RequestParam(value = "photo", required = false) MultipartFile photo) {
        try {
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setNom(nom);
            utilisateur.setLogin(login);
            utilisateur.setEmail(email);
            utilisateur.setPassword(password);
            if (photo != null && !photo.isEmpty()) {
                utilisateur.setPhotoFile(photo.getBytes());
            }
            utilisateurService.createUser(utilisateur);
            return new ResponseEntity<>(utilisateur, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT); // Login ou email déjà utilisé
        }
    }

    // Récupérer un utilisateur par login
    @GetMapping("/{login}")
    public ResponseEntity<Utilisateur> getUtilisateur(@PathVariable String login) {
        Utilisateur utilisateur = utilisateurService.findByUsername(login);
        return utilisateur != null
                ? new ResponseEntity<>(utilisateur, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Mettre à jour un utilisateur
    @PutMapping(value = "/{login}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Utilisateur> updateUtilisateur(
            @PathVariable String login,
            @RequestParam("nom") @NotBlank(message = "Le nom est requis") String nom,
            @RequestParam("email") @NotBlank(message = "L'email est requis") @Email(message = "L'email doit être valide") String email,
            @RequestParam(value = "password", required = false) String password,
            @RequestParam(value = "photo", required = false) MultipartFile photo) {
        try {
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setNom(nom);
            utilisateur.setEmail(email);
            utilisateur.setPassword(password);
            if (photo != null && !photo.isEmpty()) {
                utilisateur.setPhotoFile(photo.getBytes());
            }
            utilisateurService.updateUser(login, utilisateur);
            return new ResponseEntity<>(utilisateur, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Supprimer un utilisateur
    @DeleteMapping("/{login}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable String login) {
        utilisateurService.deleteUser(login);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Récupérer la photo d'un utilisateur
    @GetMapping("/{login}/photo")
    public ResponseEntity<byte[]> getPhoto(@PathVariable String login) {
        Utilisateur utilisateur = utilisateurService.findByUsername(login);
        if (utilisateur != null && utilisateur.getPhotoFile() != null) {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(utilisateur.getPhotoFile());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Authentification
    @PostMapping("/authentification")
    public ResponseEntity<String> authentification(
            @RequestParam("email") String email,
            @RequestParam("password") String password
    ) {
        Utilisateur User = utilisateurService.findByEmail(email);
        if (utilisateurService.validateCredentials(User.getEmail(), User.getPassword())) {
            return new ResponseEntity<>("Connexion réussie", HttpStatus.OK);
        }
        return new ResponseEntity<>("Identifiants invalides", HttpStatus.UNAUTHORIZED);
    }
}