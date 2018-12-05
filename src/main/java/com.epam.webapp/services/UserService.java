package com.epam.webapp.services;

import com.epam.webapp.entyti.User;

import java.util.Optional;

public interface UserService {
    Optional<User> login(String login, String password);
}
