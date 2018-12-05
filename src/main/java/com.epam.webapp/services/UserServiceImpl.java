package com.epam.webapp.services;

import com.epam.webapp.entyti.User;
import com.epam.webapp.repository.Repository;
import com.epam.webapp.repository.RepositoryFactory;
import com.epam.webapp.repository.specification.UserByLoginAndPasswordSpec;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Override
    public Optional<User> login(String login, String password) {

        RepositoryFactory repositoryFactory = new RepositoryFactory();
        Repository<User> repository = repositoryFactory.getUserRepository();

        UserByLoginAndPasswordSpec specification = new UserByLoginAndPasswordSpec(login, password);

        return  repository.queryForSingleResult(specification);
    }
}
