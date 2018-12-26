package com.epam.webapp.services;

import com.epam.webapp.entyti.User;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> login(String login, String password);

    List<User> findUsersByRole(String client);

    void setUserIsActive(int userId, boolean isActive);
}
