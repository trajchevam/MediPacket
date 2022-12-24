package dians.finki.ukim.mk.lab.service;


import dians.finki.ukim.mk.lab.model.User;

public interface UserService {

    User register(String username, String password, String name, String email);

}
