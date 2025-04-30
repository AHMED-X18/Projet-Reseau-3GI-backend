package Repository;

import Models.API;
import Models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Utilisateur_Repository extends JpaRepository<Utilisateur,String>{
    List<Utilisateur> FindByName(String nom);
    List<Utilisateur> FindByEmail(String email);

    Utilisateur findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    Utilisateur findByEmail(String email);
}
