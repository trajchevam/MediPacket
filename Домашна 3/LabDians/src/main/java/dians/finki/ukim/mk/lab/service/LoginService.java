package dians.finki.ukim.mk.lab.service;

import dians.finki.ukim.mk.lab.model.User;

public interface LoginService {
    User login(String username, String password);
}
