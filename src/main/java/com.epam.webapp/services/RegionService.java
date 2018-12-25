package com.epam.webapp.services;

import com.epam.webapp.entyti.Region;
import com.epam.webapp.entyti.enums.RepositoryType;
import com.epam.webapp.repository.Repository;
import com.epam.webapp.repository.RepositoryFactory;
import com.epam.webapp.repository.specification.AllInfoSpecification;
import com.epam.webapp.repository.specification.ByIdSpecification;
import com.epam.webapp.repository.specification.Specification;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

public class RegionService {
    public Set<Region> getAllRegionsList() {
        RepositoryFactory factory = new RepositoryFactory();
        Repository regionRepository = factory.getRepository(RepositoryType.REGION_REPOSITORY);
        Specification specification = new AllInfoSpecification();
        List regions = regionRepository.query(specification);
        return new TreeSet<>(regions);
    }

    public Optional<Region> findRegionById(int regionId) {
        RepositoryFactory factory = new RepositoryFactory();
        Repository repository = factory.getRepository(RepositoryType.REGION_REPOSITORY);
        Specification specification = new ByIdSpecification(regionId);
        return repository.queryForSingleResult(specification);
    }

}
