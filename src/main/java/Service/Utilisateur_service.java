package Service;
import Models.Utilisateur;
import Repository.Utilisateur_Repository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

@Service
public class Utilisateur_service {

    @Autowired
    private Utilisateur_Repository userRepository;

    public List<Utilisateur> findAll() {
        return userRepository.findAll();
    }

    public Utilisateur findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Utilisateur createUser(@NotNull Utilisateur user) {
        // Vérification de l'existence de l'utilisateur
        if (userRepository.existsByUsername(user.getNom())) {
            throw new RuntimeException("Nom d'utilisateur déja existant");
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email déjà existant");
        }
        // Hachage du mot de passe
        user.setPassword(hashPassword(user.getPassword()));
        return userRepository.save(user);
    }

    private String hashPassword(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public Utilisateur findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Utilisateur updateUser(String username, Utilisateur user) {
        Utilisateur new_user = findByUsername(username);
        if (new_user == null) {
            new_user=findByEmail(user.getEmail());
            if (new_user == null) {
                throw new RuntimeException("Pas d'utilisateur trouvé");
            }
            new_user.setNom(user.getNom());
            new_user.setPassword(hashPassword(user.getPassword())); // Hachage du nouveau mot de passe
            return userRepository.save(new_user);
        }
        new_user.setEmail(user.getEmail());
        new_user.setPassword(hashPassword(user.getPassword())); // Hachage du nouveau mot de passe
        return userRepository.save(new_user);
    }
    public void deleteUser(String identifiant) {
        if (findByEmail(identifiant) == null && findByUsername(identifiant)==null) {
            throw new RuntimeException("Utilisateur non trouvé");
        }
        else if(findByUsername(identifiant)!=null){
            Utilisateur user = findByUsername(identifiant);
            userRepository.delete(user);
        }
        else{
            Utilisateur user = findByEmail(identifiant);
            userRepository.delete(user);
        }
    }

    public boolean existById(String id){
        return userRepository.existsById(id);
    }

}

