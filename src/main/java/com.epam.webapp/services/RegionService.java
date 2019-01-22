package com.epam.webapp.services;

import com.epam.webapp.entyti.Region;
import com.epam.webapp.entyti.enums.RepositoryType;
import com.epam.webapp.exception.RepositoryException;
import com.epam.webapp.exception.ServiceExeption;
import com.epam.webapp.repository.Repository;
import com.epam.webapp.repository.RepositoryFactory;
import com.epam.webapp.repository.specification.FindAllInfoSpecification;
import com.epam.webapp.repository.specification.FindByIdSpecification;
import com.epam.webapp.repository.specification.Specification;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

public class RegionService {
    public Set<Region> getAllRegionsList() throws ServiceExeption {
        try (RepositoryFactory factory = new RepositoryFactory()) {
            Repository regionRepository = factory.getRepository(RepositoryType.REGION_REPOSITORY);
            Specification specification = new FindAllInfoSpecification();
            List regions = regionRepository.query(specification);
            return new TreeSet<>(regions);
        } catch (RepositoryException e) {
            throw new ServiceExeption(e.getMessage(), e);
        }
    }

    public Optional<Region> findRegionById(int regionId) throws ServiceExeption {
        try (RepositoryFactory factory = new RepositoryFactory()) {
            Repository repository = factory.getRepository(RepositoryType.REGION_REPOSITORY);
            Specification specification = new FindByIdSpecification(regionId);
            return repository.queryForSingleResult(specification);
        } catch (RepositoryException e) {
            throw new ServiceExeption(e.getMessage(), e);
        }
    }

}
