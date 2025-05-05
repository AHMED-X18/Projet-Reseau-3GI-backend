package com._GI.Network.project.Controller;

import com._GI.Network.project.Models.Utilisateur;
import com._GI.Network.project.Service.UtilisateurService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping("/inscription")
    public String createUtilisateur(
            @ModelAttribute Utilisateur utilisateur,
            @RequestParam("photo") @NotNull MultipartFile file) {

        utilisateur.setPhotoFile(file); // Convertir et enregistrer
        utilisateurService.createUser(utilisateur);
        return "redirect:/accueil.html";

    }

    @GetMapping("/{id}")
    public @NotNull String getById(@PathVariable String id, Model model) {
        Utilisateur utilisateur = utilisateurService.findByUsername(id);
        if (utilisateur != null) {
            model.addAttribute("utilisateur", utilisateur);
            return "utilisateur"; // Return a view for displaying the user
        }
        return "error"; // Return an error view if not found
    }

    @PutMapping("/{id}")
    public @NotNull String updateUtilisateur(@PathVariable String id, @ModelAttribute Utilisateur utilisateur) {
        utilisateurService.updateUser(id, utilisateur);
        return "redirect:/utilisateurs/" + id; // Redirect to the updated user
    }

    @DeleteMapping("/{id}")
    public @NotNull String deleteUtilisateur(@PathVariable String id) {
        utilisateurService.deleteUser(id);
        return "redirect:/utilisateurs"; // Redirect after deletion
    }

    @GetMapping("/photo/{userId}")
    public ResponseEntity<byte[]> getPhoto(@PathVariable String userId) throws IOException {
        Utilisateur user = utilisateurService.findByUsername(userId);

        if (user == null || user.getPhotoFile() == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG) // Adjust based on your file type
                .body(user.getPhotoFile().getBytes());
    }
}