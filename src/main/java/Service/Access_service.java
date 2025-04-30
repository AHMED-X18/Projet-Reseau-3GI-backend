package Service;
import Models.Access;
import Models.Id_access;
import Repository.Access_Repository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class Access_service {

    @Autowired
    private Access_Repository AccessRepository;

    public List<Access> findAll() {
        return AccessRepository.findAll();
    }

    public Access findByDate(Date date) {
        return AccessRepository.findByDate(date);
    }

    public Access createAccess(@NotNull Access access) {
        // Vérification de l'existence de l'utilisateur
        if (AccessRepository.existsById(access.getAccess())) {
            throw new RuntimeException("Acces déja existant");
        }
        access.setDate_connexion(access.getDate_connexion());
        access.setHeure_connexion(access.getHeure_connexion());
        access.setAccess(access.getAccess());
        access.setAPI(access.getAPI());
        access.setUser(access.getUser());
        return AccessRepository.save(access);
    }

    public Access findById(Id_access id){
        return AccessRepository.findbyId(id);
    }

}

