package com.epam.webapp.services;

import com.epam.webapp.entyti.Car;
import com.epam.webapp.entyti.FreeCarComparator;
import com.epam.webapp.entyti.enums.RepositoryType;
import com.epam.webapp.repository.Repository;
import com.epam.webapp.repository.RepositoryFactory;
import com.epam.webapp.repository.specification.FindByIdSpecification;
import com.epam.webapp.repository.specification.FindCarsByBusySpecification;
import com.epam.webapp.repository.specification.Specification;

import java.util.*;

public class CarService {
    public Set<Car> findFreeCarsNear(int startRegionZone) {
        Set<Car> freeCars = new TreeSet<>(new FreeCarComparator(startRegionZone));
        freeCars.addAll(findAllFreeCars());
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

    public List<Car> findAllFreeCars() {
        RepositoryFactory factory = new RepositoryFactory();
        Repository repository = factory.getRepository(RepositoryType.CAR_REPOSITORY);
        Specification specification = new FindCarsByBusySpecification(false);
        return repository.query(specification);
    }

    public Optional<Car> findCarById(int id) {
        RepositoryFactory factory = new RepositoryFactory();
        Repository repository = factory.getRepository(RepositoryType.CAR_REPOSITORY);
        Specification specification = new FindByIdSpecification(id);
        return repository.queryForSingleResult(specification);
    }
}
