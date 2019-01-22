package com.epam.webapp.services;

import com.epam.webapp.entyti.Identifiable;
import com.epam.webapp.entyti.Ride;
import com.epam.webapp.entyti.User;
import com.epam.webapp.entyti.enums.RepositoryType;
import com.epam.webapp.exception.RepositoryException;
import com.epam.webapp.exception.ServiceExeption;
import com.epam.webapp.repository.Repository;
import com.epam.webapp.repository.RepositoryFactory;
import com.epam.webapp.repository.specification.DeleteByIdSpecification;
import com.epam.webapp.repository.specification.FindFinishedRideForDriverSpecification;
import com.epam.webapp.repository.specification.FindRideByClientIdSpecification;
import com.epam.webapp.repository.specification.Specification;
import com.epam.webapp.repository.specification.FindRideByIdSpecification;
import com.epam.webapp.repository.specification.DeleteAllUnacceptedRequestByDriverIdSpecification;


import java.util.List;
import java.util.Optional;

public class RideService {
    public void addRide(Identifiable ride) throws ServiceExeption {
        try (RepositoryFactory factory = new RepositoryFactory()) {
            Repository repository = factory.getRepository(RepositoryType.RIDE_REPOSITORY);
            repository.save(ride);
        } catch (RepositoryException e) {
            throw new ServiceExeption(e.getMessage(), e);
        }
    }

    public List<Ride> findClientTrips(User user) throws ServiceExeption {
        try (RepositoryFactory factory = new RepositoryFactory();) {
            Repository repository = factory.getRepository(RepositoryType.RIDE_REPOSITORY);
            Specification specification = new FindRideByClientIdSpecification(user.getId());
            return repository.query(specification);
        } catch (RepositoryException e) {
            throw new ServiceExeption(e.getMessage(), e);
        }
    }

    public void removeRide(int id) throws ServiceExeption {
        try (RepositoryFactory factory = new RepositoryFactory()) {
            Repository repository = factory.getRepository(RepositoryType.RIDE_REPOSITORY);
            Specification specification = new DeleteByIdSpecification(id, true);
            repository.delete(specification);
        } catch (RepositoryException e) {
            throw new ServiceExeption(e.getMessage(), e);
        }
    }

    public List<Ride> findUnfinishedDriverTrips(User driver) throws ServiceExeption {
        try (RepositoryFactory factory = new RepositoryFactory()) {
            Repository repository = factory.getRepository(RepositoryType.RIDE_REPOSITORY);
            Specification specification = new FindFinishedRideForDriverSpecification(driver.getId(), false);
            return repository.query(specification);
        } catch (RepositoryException e) {
            throw new ServiceExeption(e.getMessage(), e);
        }
    }

    public void acceptRide(int rideId, int driverId) throws ServiceExeption {
        try (RepositoryFactory factory = new RepositoryFactory()) {
            Repository repository = factory.getRepository(RepositoryType.RIDE_REPOSITORY);
            Specification specification = new FindRideByIdSpecification(rideId);
            Optional<Ride> result = repository.queryForSingleResult(specification);
            if (result.isPresent()) {
                Ride ride = result.get();
                ride.setAccepted(true);
                repository.save(ride);
                Specification deleteSpecification = new DeleteAllUnacceptedRequestByDriverIdSpecification(driverId);
                repository.delete(deleteSpecification);
            }
        } catch (RepositoryException e) {
            throw new ServiceExeption(e.getMessage(), e);
        }
    }

    public void acceptPay(int rideId) throws ServiceExeption {
        try (RepositoryFactory factory = new RepositoryFactory()) {
            Repository repository = factory.getRepository(RepositoryType.RIDE_REPOSITORY);
            Specification specification = new FindRideByIdSpecification(rideId);
            Optional<Ride> result = repository.queryForSingleResult(specification);
            if (result.isPresent()) {
                Ride ride = result.get();
                ride.setPayed(true);
                repository.save(ride);
            }
        } catch (RepositoryException e) {
            throw new ServiceExeption(e.getMessage(), e);
        }
    }

    public void finishRide(int rideId) throws ServiceExeption {
        try (RepositoryFactory factory = new RepositoryFactory()) {
            Repository repository = factory.getRepository(RepositoryType.RIDE_REPOSITORY);
            Specification specification = new FindRideByIdSpecification(rideId);
            Optional<Ride> result = repository.queryForSingleResult(specification);
            if (result.isPresent()) {
                Ride ride = result.get();
                ride.setFinished(true);
                repository.save(ride);
            }
        } catch (RepositoryException e) {
            throw new ServiceExeption(e.getMessage(), e);
        }
    }

    public Optional<Ride> findUnfinishedClientRide(User user) throws ServiceExeption {
        List<Ride> rideForCurrentClient = findClientTrips(user);
        for (Ride ride : rideForCurrentClient) {
            if (!ride.isFinished()) {
                return Optional.of(ride);
            }
        }
        return Optional.empty();
    }

}
