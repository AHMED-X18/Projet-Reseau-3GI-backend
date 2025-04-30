package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class  MyView {
    @GetMapping("/")
    public String showView() {
        // Retourne le nom de la vue (template)
        return "redirect:/presentation.html";
        }
}
