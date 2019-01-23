package com.epam.webapp.repository;

import com.epam.webapp.builder.CarBuilder;
import com.epam.webapp.entyti.Car;
import com.epam.webapp.entyti.enums.OperationType;
import com.epam.webapp.exception.RepositoryException;
import com.epam.webapp.repository.specification.Specification;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CarRepository extends AbstractRepository<Car> {
    private static final String SQL = "select * from cars ";
    private static final String UPDATE_SQL = "update cars set ";
    private static final String INSERT_SQL = "insert into cars ";

    public CarRepository(Connection connection) {
        super(connection);
    }

    @Override
    public List<Car> query(Specification specification) throws RepositoryException {
        String sql = SQL + specification.toSql();
        return executeQuery(sql, new CarBuilder(), specification.getParams());
    }

    @Override
    public Optional<Car> queryForSingleResult(Specification specification) throws RepositoryException {
        String sql = SQL + specification.toSql();
        List<Car> cars = executeQuery(sql, new CarBuilder(), specification.getParams());
        if (!cars.isEmpty()) {
            return Optional.of(cars.get(0));
        } else {
            return Optional.empty();
        }
    }

    @Override
    protected String toSql(OperationType operationType) {
        if (operationType == OperationType.INSERT){
            return  INSERT_SQL;
        }else {
           return UPDATE_SQL;
        }
    }

    @Override
    protected Map<String, Object> makeMap(Car car) {
        Map<String, Object> map = new HashMap<>();
        map.put("driver_id",car.getId());
        map.put("car_name",car.getCarBrand());
        map.put("car_model", car.getCarModel());
        return map;
    }


    @Override
    public void delete(Specification specification) {
        throw new UnsupportedOperationException();
    }


}
