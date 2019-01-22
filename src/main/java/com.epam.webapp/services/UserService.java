package com.epam.webapp.services;

import com.epam.webapp.entyti.User;
import com.epam.webapp.entyti.enums.UserRole;
import com.epam.webapp.exception.ServiceExeption;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> login(String login, String password) throws ServiceExeption;

    List<User> findUsersByRole(UserRole userRole) throws ServiceExeption;

    void setUserIsActive(int userId, boolean isActive) throws ServiceExeption;

     List<User> uploadUserList() throws ServiceExeption;
}
