package com.epam.webapp.services;


import com.epam.webapp.entyti.Discount;
import com.epam.webapp.entyti.enums.RepositoryType;
import com.epam.webapp.repository.Repository;
import com.epam.webapp.repository.RepositoryFactory;
import com.epam.webapp.repository.specification.FindByIdSpecification;
import com.epam.webapp.repository.specification.Specification;

import java.util.Optional;

public class DiscountService {
    public Optional<Discount> findDiscountById(int id) {
        RepositoryFactory repositoryFactory = new RepositoryFactory();
        Repository repository = repositoryFactory.getRepository(RepositoryType.DISCOUNT_REPOSITORY);
        Specification specification = new FindByIdSpecification(id);
        return repository.queryForSingleResult(specification);
    }
}
