package com.epam.webapp.services;

import com.epam.webapp.entyti.User;
import com.epam.webapp.entyti.enums.RepositoryType;
import com.epam.webapp.repository.Repository;
import com.epam.webapp.repository.RepositoryFactory;
import com.epam.webapp.repository.specification.UserByLoginAndPasswordSpec;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Override
    public Optional<User> login(String login, String password) {
        RepositoryFactory repositoryFactory = new RepositoryFactory();
        Repository repository = repositoryFactory.getRepository(RepositoryType.USER_REPOSITORY);
        UserByLoginAndPasswordSpec specification = new UserByLoginAndPasswordSpec(login, password);
        return  repository.queryForSingleResult(specification);
    }
}
