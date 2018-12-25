package com.epam.webapp.repository;

import com.epam.webapp.builder.RegionBuilder;
import com.epam.webapp.entyti.Car;
import com.epam.webapp.entyti.Region;
import com.epam.webapp.repository.specification.Specification;
import com.epam.webapp.repository.template.RegionTemplate;
import com.epam.webapp.repository.template.Template;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class RegionRepository extends AbstractRepository<Region> {
    public RegionRepository(Connection connection) {
        super(connection);
    }

    @Override
    public List<Region> query(Specification specification) {
        String query = "select * from regions " + specification.toSql();
        return execyteQuery(query, new RegionBuilder(), specification.getParams());
    }

    @Override
    public Optional<Region> queryForSingleResult(Specification specification) {
        String query = "select * from regions " + specification.toSql();
        List<Region> regions = execyteQuery(query, new RegionBuilder(), specification.getParams());
        return !regions.isEmpty() ? Optional.of(regions.get(0)) : Optional.empty();
    }

    @Override
    public void insert(Template template) {
        throw  new UnsupportedOperationException();
    }

    @Override
    public void update(Specification specification) {
        throw    new UnsupportedOperationException();
    }

    @Override
    public void delete(Specification specification) {
        throw   new UnsupportedOperationException();
    }
}
