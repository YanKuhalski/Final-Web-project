package com.epam.webapp.repository;

import com.epam.webapp.repository.specification.Specification;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    List<T> query(Specification specification);

    Optional<T> queryForSingleResult(Specification specification);
}
