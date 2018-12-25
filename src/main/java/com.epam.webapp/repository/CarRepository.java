package com.epam.webapp.repository;

import com.epam.webapp.builder.CarBuilder;
import com.epam.webapp.entyti.Car;
import com.epam.webapp.repository.specification.Specification;
import com.epam.webapp.repository.template.CarTemplate;
import com.epam.webapp.repository.template.Template;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class CarRepository extends AbstractRepository<Car> {
    public CarRepository(Connection connection) {
        super(connection);
    }

    @Override
    public List<Car> query(Specification specification) {
        String sql = "select * from cars " + specification.toSql();
        return execyteQuery(sql, new CarBuilder(), specification.getParams());
    }

    @Override
    public Optional<Car> queryForSingleResult(Specification specification) {
        String sql = "select * from cars " + specification.toSql();
        List<Car> cars = execyteQuery(sql, new CarBuilder(), specification.getParams());
        if (!cars.isEmpty()) {
            return Optional.of(cars.get(0));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void insert(Template template) {
        throw  new UnsupportedOperationException();
    }

    @Override
    public void update(Specification specification) {
        throw  new UnsupportedOperationException();
    }

    @Override
    public void delete(Specification specification) {
        throw  new UnsupportedOperationException();
    }
}
