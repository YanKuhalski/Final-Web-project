package com.epam.webapp.repository;

import com.epam.webapp.entyti.Identifiable;
import com.epam.webapp.exception.RepositoryException;
import com.epam.webapp.repository.specification.Specification;

import java.util.List;
import java.util.Optional;

public interface Repository<T extends Identifiable>  {
    List<T> query(Specification specification) throws RepositoryException;

    Optional<T> queryForSingleResult(Specification specification) throws RepositoryException;
     void save(T item) throws RepositoryException;
    void  delete(Specification specification) throws RepositoryException;
}
