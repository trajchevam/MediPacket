package dians.finki.ukim.mk.lab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String getHomePage(Model model){
        model.addAttribute("bodyContent","create-button");
        return "master-template";
    }

    @GetMapping("/aboutUs")
    public String getAboutUsPage(Model model){
        return "about-us";
    }

    @GetMapping("/pharmacies")
    public String getPharmaciesPage(Model model){
        return "pharmacies";
    }
}
