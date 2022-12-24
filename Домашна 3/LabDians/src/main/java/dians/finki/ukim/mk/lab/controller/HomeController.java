package dians.finki.ukim.mk.lab.controller;

import dians.finki.ukim.mk.lab.service.PharmacyService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    private final PharmacyService pharmacyService;

    public HomeController(PharmacyService pharmacyService) {
        this.pharmacyService = pharmacyService;
    }

    @GetMapping
    public String getIndexPage(Model model, HttpServletRequest req){
        model.addAttribute("username", req.getSession().getAttribute("username"));
        model.addAttribute("bodyContent", "register");
        return "master-template";
    }

    @GetMapping("/about-us")
    public String getAboutUsPage(Model model, HttpServletRequest req){
        model.addAttribute("username", req.getSession().getAttribute("username"));
        model.addAttribute("bodyContent", "about-us");
        return "master-template";
    }

    @GetMapping("/pharmacies")
    public String getPharmaciesPage(Model model, HttpServletRequest req){
        model.addAttribute("pharmacies", pharmacyService.listAll());
        model.addAttribute("username", req.getSession().getAttribute("username"));
        return "pharmacies";
    }

    @GetMapping("/pharmacies/packet")
    public String getPacketPage(Model model, HttpServletRequest req){
        model.addAttribute("bodyContent", "create-package");
        model.addAttribute("username", req.getSession().getAttribute("username"));
        model.addAttribute("packet1", null);
        model.addAttribute("packet2", null);
        return "master-template";

    }

    @PostMapping("/pharmacies/packet1")
    public String postPacket1Page(Model model, HttpServletRequest req){
        req.getSession().setAttribute("packet1", 1);
        req.getSession().setAttribute("packet2", null);
        return "redirect:/home";
    }

    @PostMapping("/pharmacies/packet2")
    public String postPacket2Page(Model model, HttpServletRequest req){
        req.getSession().setAttribute("packet2", 1);
        req.getSession().setAttribute("packet1", null);
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String getHomePage(Model model, HttpServletRequest req){
        model.addAttribute("packet1", req.getSession().getAttribute("packet1"));
        model.addAttribute("packet2", req.getSession().getAttribute("packet2"));
        model.addAttribute("bodyContent", "home");
        model.addAttribute("username", req.getSession().getAttribute("username"));
        return "master-template";
    }
}


