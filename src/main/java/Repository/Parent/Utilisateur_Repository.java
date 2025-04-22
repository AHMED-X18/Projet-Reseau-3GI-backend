package Repository.Parent;

import Models.API;
import Models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Utilisateur_Repository extends JpaRepository<Utilisateur,String>{
    List<Utilisateur> FindByName(String nom);
    List<Utilisateur> FindByEmail(String email);
}
