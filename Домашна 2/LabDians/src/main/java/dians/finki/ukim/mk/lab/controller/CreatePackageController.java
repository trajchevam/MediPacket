package dians.finki.ukim.mk.lab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/create")
public class CreatePackageController {

    @GetMapping
    public String getCreatePage(Model model){
        return "create-package";
    }
}
