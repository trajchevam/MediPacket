package dians.finki.ukim.mk.lab.service.impl;

import dians.finki.ukim.mk.lab.model.User;
import dians.finki.ukim.mk.lab.model.exceptions.InvalidArgumentsException;
import dians.finki.ukim.mk.lab.model.exceptions.InvalidUsernameOrPasswordException;
import dians.finki.ukim.mk.lab.repository.UserRepository;
import dians.finki.ukim.mk.lab.service.LoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    private final UserRepository userRepository;

    public LoginServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if (username==null || username.isEmpty() || password==null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }

            User user = this.userRepository.findByUsernameAndPassword(username, password);
            if(user == null) throw new InvalidUsernameOrPasswordException();
            userRepository.save(user);
            return user;



    }
}
