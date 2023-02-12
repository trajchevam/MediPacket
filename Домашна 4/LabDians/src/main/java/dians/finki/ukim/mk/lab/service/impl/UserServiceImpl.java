package dians.finki.ukim.mk.lab.service.impl;

import dians.finki.ukim.mk.lab.model.User;
import dians.finki.ukim.mk.lab.model.exceptions.InvalidUsernameOrPasswordException;
import dians.finki.ukim.mk.lab.model.exceptions.PasswordsDoNotMatchException;
import dians.finki.ukim.mk.lab.model.exceptions.UsernameAlreadyExistsException;
import dians.finki.ukim.mk.lab.repository.UserRepository;
import dians.finki.ukim.mk.lab.service.UserService;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User register(String username, String password, String name, String email) {
        if (username==null || username.isEmpty()  || password==null || password.isEmpty())
            throw new InvalidUsernameOrPasswordException();
        if(this.userRepository.findByUsername(username).isPresent())
            throw new UsernameAlreadyExistsException(username);

        User user = new User (username, password, name, email);
        userRepository.save(user);
        return user;

    }
}
