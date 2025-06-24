package com._GI.Network.project.Service;

import com._GI.Network.project.Models.Utilisateur;
import com._GI.Network.project.Repository.UtilisateurRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository userRepository;

    public List<Utilisateur> findAll() {
        return userRepository.findAll();
    }

    public Utilisateur findByUsername(String username) {
        return userRepository.findByLogin(username);
    }

    @Transactional
    public void createUser(Utilisateur user) {
        if (userRepository.existsByLogin(user.getLogin())) {
            throw new RuntimeException("Nom d'utilisateur déjà existant");
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email déjà existant");
        }
        user.setPassword(hashPassword(user.getPassword()));
        userRepository.save(user);
    }

    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public Utilisateur findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Transactional
    public void updateUser(String username, Utilisateur user) {
        Utilisateur existingUser = findByUsername(username);
        if (existingUser == null) {
            existingUser = findByEmail(user.getEmail());
            if (existingUser == null) {
                throw new RuntimeException("Pas d'utilisateur trouvé");
            }
        }
        existingUser.setNom(user.getNom());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(hashPassword(user.getPassword()));
        userRepository.save(existingUser);
    }

    @Transactional
    public void deleteUser(String identifiant) {
        Utilisateur user = findByUsername(identifiant);
        if (user == null) {
            user = findByEmail(identifiant);
            if (user == null) {
                throw new RuntimeException("Utilisateur non trouvé");
            }
        }
        userRepository.delete(user);
    }

    public boolean existById(String id) {
        return userRepository.existsById(id);
    }

    public boolean validateCredentials(String email, String password) {
        Utilisateur utilisateur = findByEmail(email);
        return utilisateur != null ;
    }
}