package dians.finki.ukim.mk.lab.controller;

import dians.finki.ukim.mk.lab.model.User;
import dians.finki.ukim.mk.lab.model.exceptions.InvalidUserCredentialsException;
import dians.finki.ukim.mk.lab.model.exceptions.InvalidUsernameOrPasswordException;
import dians.finki.ukim.mk.lab.repository.UserRepository;
import dians.finki.ukim.mk.lab.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final UserRepository userRepository;
    private final LoginService loginService;

    public LoginController(UserRepository userRepository, LoginService loginService) {
        this.userRepository = userRepository;
        this.loginService = loginService;
    }

    @GetMapping
    public String getLoginPage(Model model, @RequestParam(required = false) boolean error) {

            model.addAttribute("hasError", error);
            model.addAttribute("bodyContent","login");
            return "master-template";

    }
    @PostMapping
    public String Login(HttpServletRequest req,
                        @RequestParam String username,
                        @RequestParam String password,
                        Model model){

        try {
            loginService.login(username, password);
            req.getSession().setAttribute("username", username);

            return "redirect:/pharmacies";
        }

        catch (InvalidUsernameOrPasswordException exception){
            return "redirect:/login?error=true";
        }

    }

    @PostMapping("/logout")
    public String Logout(HttpServletRequest req, Model model){
        req.getSession().setAttribute("username", null);
        return "redirect:/";
    }

}
