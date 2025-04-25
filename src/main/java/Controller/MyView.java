package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class  MyView {
    @GetMapping("/ma-vue")
    public String afficherMaVue(Model model) {
        // Ajout d'attributs au modèle
        model.addAttribute("message", "Bonjour depuis Spring Boot!");
        model.addAttribute("titre", "Ma première vue");

        // Retourne le nom de la vue (template)
        return "acceuil";
        }
}
