package com.epam.webapp.services;

import com.epam.webapp.entyti.User;
import com.epam.webapp.entyti.enums.RepositoryType;
import com.epam.webapp.repository.Repository;
import com.epam.webapp.repository.RepositoryFactory;
import com.epam.webapp.repository.specification.FindUserByLoginAndPasswordSpec;
import com.epam.webapp.repository.specification.FindUserByRoleSpecification;
import com.epam.webapp.repository.specification.Specification;
import com.epam.webapp.repository.specification.UpdateUserIsActiveSpecification;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Override
    public Optional<User> login(String login, String password) {
        RepositoryFactory repositoryFactory = new RepositoryFactory();
        Repository repository = repositoryFactory.getRepository(RepositoryType.USER_REPOSITORY);
        FindUserByLoginAndPasswordSpec specification = new FindUserByLoginAndPasswordSpec(login, password);
        return repository.queryForSingleResult(specification);
    }

    @Override
    public List<User> findUsersByRole(String role) {
        List<User> users = new ArrayList<>();
        RepositoryFactory repositoryFactory = new RepositoryFactory();
        Repository repository = repositoryFactory.getRepository(RepositoryType.USER_REPOSITORY);
        Specification specification = new FindUserByRoleSpecification(role);
        return repository.query(specification);
    }

    @Override
    public void setUserIsActive(int userId, boolean isActive) {
        RepositoryFactory repositoryFactory = new RepositoryFactory();
        Repository repository = repositoryFactory.getRepository(RepositoryType.USER_REPOSITORY);
        Specification specification = new UpdateUserIsActiveSpecification(userId,isActive);
        repository.update(specification);

    }
}
