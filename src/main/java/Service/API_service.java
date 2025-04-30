package Service;
import Models.API;
import Repository.API_repository;
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

    public API updateAPI(String nom, API api) {
        API new_api = findByName(nom);
        if (new_api == null) {
            throw new RuntimeException("Pas d'API trouvé");
        }
        new_api.setDescription(api.getDescription());
        new_api.setURL(api.getURL());
        new_api.setNom(api.getNom());
        return APIRepository.save(new_api);
    }

    public void deleteAPI(String identifiant) {
        if (findByName(identifiant)==null) {
            throw new RuntimeException("API non trouvé");
        }
        API api = findByName(identifiant);
        APIRepository.delete(api);
    }
    public boolean existById(String id){
        return APIRepository.existsById(id);
    }
}

