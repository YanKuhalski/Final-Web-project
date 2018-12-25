package com.epam.webapp.services;

import com.epam.webapp.entyti.Ride;
import com.epam.webapp.entyti.User;
import com.epam.webapp.entyti.enums.RepositoryType;
import com.epam.webapp.repository.Repository;
import com.epam.webapp.repository.RepositoryFactory;
import com.epam.webapp.repository.specification.RideByClientIdSpecification;
import com.epam.webapp.repository.specification.Specification;
import com.epam.webapp.repository.template.Template;

import java.util.List;

public class RideService {
    public void addRide(Template ride) {
        RepositoryFactory factory = new RepositoryFactory();
        Repository repository = factory.getRepository(RepositoryType.RIDE_REPOSITORY);
        repository.insert(ride);
    }

    public List<Ride> findRideForCurrentClient(User user) {
        RepositoryFactory factory = new RepositoryFactory();
        Repository repository = factory.getRepository(RepositoryType.RIDE_REPOSITORY);
        Specification specification = new RideByClientIdSpecification(user.getId());
        return repository.query(specification);
    }
}
