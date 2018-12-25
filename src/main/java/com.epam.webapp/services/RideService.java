package com.epam.webapp.services;

import com.epam.webapp.entyti.Ride;
import com.epam.webapp.entyti.User;
import com.epam.webapp.entyti.enums.RepositoryType;
import com.epam.webapp.repository.Repository;
import com.epam.webapp.repository.RepositoryFactory;

import com.epam.webapp.repository.specification.DeleteByIdSpecification;
import com.epam.webapp.repository.specification.FindFinishedRideForDriverSpecification;
import com.epam.webapp.repository.specification.UpdateRideStatusByIdSpecification;
import com.epam.webapp.repository.specification.DeleteAllUnacceptedRequestByDriverIdSpecification;
import com.epam.webapp.repository.specification.FindRideByClientIdSpecification;
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
        Specification specification = new FindRideByClientIdSpecification(user.getId());
        return repository.query(specification);
    }

    public void removeRide(int id) {
        RepositoryFactory factory = new RepositoryFactory();
        Repository repository = factory.getRepository(RepositoryType.RIDE_REPOSITORY);
        Specification specification = new DeleteByIdSpecification(id, true);
        repository.delete(specification);
    }

    public List<Ride> findRideForCurrentDriver(User driver) {
        RepositoryFactory factory = new RepositoryFactory();
        Repository repository = factory.getRepository(RepositoryType.RIDE_REPOSITORY);
        Specification specification = new FindFinishedRideForDriverSpecification(driver.getId(), false);
        return repository.query(specification);
    }

    public void acceptRide(int rideId,int driverId) {
        RepositoryFactory factory = new RepositoryFactory();
        Repository repository = factory.getRepository(RepositoryType.RIDE_REPOSITORY);
        Specification specification = new UpdateRideStatusByIdSpecification(rideId, true, false);
        repository.update(specification);
        Specification deleteSpecification = new DeleteAllUnacceptedRequestByDriverIdSpecification(driverId);
        repository.delete(deleteSpecification);
    }

    public void acceptPay(int rideId) {
        RepositoryFactory factory = new RepositoryFactory();
        Repository repository = factory.getRepository(RepositoryType.RIDE_REPOSITORY);
        Specification specification = new UpdateRidePayStatusByIdSpecification(rideId, true);
        repository.update(specification);
    }

    public void finishRide(int rideId) {
        RepositoryFactory factory = new RepositoryFactory();
        Repository repository = factory.getRepository(RepositoryType.RIDE_REPOSITORY);
        Specification specification = new UpdateRideStatusByIdSpecification(rideId, true, true);
        repository.update(specification);
    }

}
