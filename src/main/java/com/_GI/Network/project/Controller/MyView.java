package com._GI.Network.project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class  MyView {
    @GetMapping("/")
    public String showView() {
        return "redirect:/index.html";
    }

}
