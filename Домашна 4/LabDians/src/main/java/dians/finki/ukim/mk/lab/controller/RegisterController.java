package dians.finki.ukim.mk.lab.controller;

import dians.finki.ukim.mk.lab.model.exceptions.InvalidArgumentsException;
import dians.finki.ukim.mk.lab.model.exceptions.PasswordsDoNotMatchException;
import dians.finki.ukim.mk.lab.service.LoginService;
import dians.finki.ukim.mk.lab.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final UserService userService;
    private final LoginService loginService;

    public RegisterController(UserService userService, LoginService loginService) {
        this.userService = userService;
        this.loginService = loginService;
    }

    @GetMapping
    public String getRegisterPage(Model model){
        model.addAttribute("bodyContent", "register");
        return "master-template";
    }


    @PostMapping
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String name,
                           @RequestParam String email){
        try{
            this.userService.register(username, password, name, email);
            return "redirect:/login";
        }
        catch (InvalidArgumentsException | PasswordsDoNotMatchException exception){
            return "redirect:/register?error=" + exception.getMessage();
        }
    }
}
