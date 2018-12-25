package com.epam.webapp.repository;


import com.epam.webapp.builder.CarBuilder;
import com.epam.webapp.builder.RideBuilder;
import com.epam.webapp.entyti.Ride;
import com.epam.webapp.repository.specification.Specification;
import com.epam.webapp.repository.template.RideTemplate;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class RideRepository extends AbstractRepository<Ride, RideTemplate> {


    public RideRepository(Connection connection) {
        super(connection);
    }

    @Override
    public List<Ride> query(Specification specification) {
        String sql = "select * from rides " + specification.toSql();
        List<Ride> rides = execyteQuery(sql, new RideBuilder(), specification.getParams());
        return rides;
    }

    @Override
    public Optional<Ride> queryForSingleResult(Specification specification) {

        throw new UnsupportedOperationException();
    }

    @Override
    public void insert(RideTemplate rideTemplate) {
        String sql = " insert into rides " + rideTemplate.toSql();
        execyteUpdate(sql, rideTemplate.getValues());
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(int id, RideTemplate rideTemplate) {
        throw new UnsupportedOperationException();

    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException();
    }
}
