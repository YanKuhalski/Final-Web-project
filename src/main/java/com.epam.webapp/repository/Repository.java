package com.epam.webapp.repository;

import com.epam.webapp.entyti.Ride;
import com.epam.webapp.repository.specification.Specification;
import com.epam.webapp.repository.template.Template;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    List<T> query(Specification specification);

    Optional<T> queryForSingleResult(Specification specification);

    void insert(Template template);

    void update(Specification specification);

    void  delete(Specification specification);
}
