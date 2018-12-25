package com.epam.webapp.services;

import com.epam.webapp.entyti.Car;
import com.epam.webapp.entyti.FreeCarComparator;
import com.epam.webapp.entyti.Region;
import com.epam.webapp.entyti.enums.RepositoryType;
import com.epam.webapp.repository.Repository;
import com.epam.webapp.repository.RepositoryFactory;
import com.epam.webapp.repository.specification.ByIdSpecification;
import com.epam.webapp.repository.specification.CarsByBusySpecification;
import com.epam.webapp.repository.specification.Specification;

import java.util.*;

public class CarService {
    public Set<Car> findFreeCarsNear(int startRegionZone) {
        RepositoryFactory factory = new RepositoryFactory();
        Repository repository = factory.getRepository(RepositoryType.CAR_REPOSITORY);
        Specification specification = new CarsByBusySpecification(false);
        Set<Car> freeCars = new TreeSet<>(new FreeCarComparator(startRegionZone));
        freeCars.addAll(repository.query(specification));
        Iterator<Car> iterator = freeCars.iterator();
        while (iterator.hasNext()) {
            Car car = iterator.next();
            int concurrentRegionId = car.getConcurrentRegionId();
            int zoneDefenition = Math.abs(concurrentRegionId - startRegionZone);
            if (zoneDefenition > 2) {
                iterator.remove();
            }
        }
        return freeCars;
    }

    public Optional<Car> findCarById(int id) {
        RepositoryFactory factory = new RepositoryFactory();
        Repository repository = factory.getRepository(RepositoryType.CAR_REPOSITORY);
        Specification specification = new ByIdSpecification(id);
        return repository.queryForSingleResult(specification);
    }
}
