package com.epam.webapp.repository;


import com.epam.webapp.builder.CarBuilder;
import com.epam.webapp.builder.RideBuilder;
import com.epam.webapp.entyti.Ride;
import com.epam.webapp.repository.specification.Specification;
import com.epam.webapp.repository.template.RideTemplate;
import com.epam.webapp.repository.template.Template;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class RideRepository extends AbstractRepository<Ride> {


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
    public void insert(Template template) {
        String sql = " insert into rides " + template.toSql();
        execyteUpdate(sql, template.getValues());
    }

    @Override
    public void update(Specification specification) {
        String sql = " update rides set " + specification.toSql();
        execyteUpdate(sql, specification.getParams());
    }

    @Override
    public void delete(Specification specification) {
        String sql = " delete from rides where " + specification.toSql();
        execyteUpdate(sql, specification.getParams());
    }
}
