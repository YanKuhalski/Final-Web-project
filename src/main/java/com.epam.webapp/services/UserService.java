package com.epam.webapp.services;

import com.epam.webapp.entyti.User;
import com.epam.webapp.entyti.enums.RepositoryType;
import com.epam.webapp.entyti.enums.UserRole;
import com.epam.webapp.exception.RepositoryException;
import com.epam.webapp.exception.ServiceExeption;
import com.epam.webapp.repository.Repository;
import com.epam.webapp.repository.RepositoryFactory;
import com.epam.webapp.repository.specification.FindByIdSpecification;
import com.epam.webapp.repository.specification.FindUserByLoginAndPasswordSpec;
import com.epam.webapp.repository.specification.FindUserByRoleSpecification;
import com.epam.webapp.repository.specification.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {

    public Optional<User> login(String login, String password) throws ServiceExeption {
        try (RepositoryFactory repositoryFactory = new RepositoryFactory()) {
            Repository repository = repositoryFactory.getRepository(RepositoryType.USER_REPOSITORY);
            FindUserByLoginAndPasswordSpec specification = new FindUserByLoginAndPasswordSpec(login, password);
            return repository.queryForSingleResult(specification);
        } catch (RepositoryException e) {
            throw new ServiceExeption(e.getMessage(), e);
        }
    }

    public List<User> findUsers(UserRole role) throws ServiceExeption {
        try (RepositoryFactory repositoryFactory = new RepositoryFactory()) {
            Repository repository = repositoryFactory.getRepository(RepositoryType.USER_REPOSITORY);
            Specification specification = new FindUserByRoleSpecification(role.getRole());
            return repository.query(specification);
        } catch (RepositoryException e) {
            throw new ServiceExeption(e.getMessage(), e);
        }
    }


    public void setUserIsActive(int userId, boolean isActive) throws ServiceExeption {
        try (RepositoryFactory repositoryFactory = new RepositoryFactory()) {
            Repository repository = repositoryFactory.getRepository(RepositoryType.USER_REPOSITORY);
            Specification specification = new FindByIdSpecification(userId);
            Optional<User> user = repository.queryForSingleResult(specification);
            if (user.isPresent()) {
                User userValue = user.get();
                userValue.setActive(isActive);
                repository.save(userValue);
            }
        } catch (RepositoryException e) {
            throw new ServiceExeption(e.getMessage(), e);
        }
    }

    public List<User> uploadUserList() throws ServiceExeption {
        List<User> users = new ArrayList<>();
        users.addAll(findUsers(UserRole.CLIENT));
        users.addAll(findUsers(UserRole.DRIVER));
        return users;
    }

    public void addUser(User user) throws ServiceExeption {
        try (RepositoryFactory factory = new RepositoryFactory()) {
            Repository repository = factory.getRepository(RepositoryType.USER_REPOSITORY);
            repository.save(user);
        } catch (RepositoryException e) {
            throw new ServiceExeption(e.getMessage(), e);
        }
    }
}
