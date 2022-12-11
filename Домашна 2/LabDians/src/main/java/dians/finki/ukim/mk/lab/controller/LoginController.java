package dians.finki.ukim.mk.lab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String getLoginPage(Model model) {
        model.addAttribute("bodyContent","login");
        return "login";
    }
    @PostMapping
    public String postLoginPage(Model model){
        return "redirect:/";
    }

}
