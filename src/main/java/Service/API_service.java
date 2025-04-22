package Service;
import Models.API;
import Repository.Parent.API_repository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

@Service
public class API_service {

    @Autowired
    private API_repository APIRepository;

    public List<API> findAll() {
        return APIRepository.findAll();
    }

    public API findByName(String nom) {
        return APIRepository.findByName(nom);
    }

    public API createAPI(@NotNull API api) {
        // Vérification de l'existence de l'utilisateur
        if (APIRepository.existsById(api.getId_API())) {
            throw new RuntimeException("API déja existante");
        }
        if (APIRepository.existsByNom(api.getNom())) {
            throw new RuntimeException("API déjà existante");
        }
        api.setDescription(api.getDescription());
        api.setNom(api.getNom());
        api.setURL(api.getURL());
        api.setId_API(api.getId_API());
        return APIRepository.save(api);
    }

    public API updateAPI(String nom, API api) {
        API new_api = findByName(nom);
        if (new_api == null) {
            throw new RuntimeException("Pas d'API trouvé");
        }
        new_api.setDescription(api.getDescription());
        new_api.setURL(api.getURL());
        new_api.setId_API(api.getId_API());
        return APIRepository.save(new_api);
    }

    public void deleteAPI(String identifiant) {
        if (findByName(identifiant)==null) {
            throw new RuntimeException("API non trouvé");
        }
        API api = findByName(identifiant);
        APIRepository.delete(api);
    }

}

