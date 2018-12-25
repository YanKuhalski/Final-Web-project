package com.epam.webapp.repository;

import com.epam.webapp.builder.DiscountBuilder;
import com.epam.webapp.builder.RegionBuilder;
import com.epam.webapp.entyti.Car;
import com.epam.webapp.entyti.Discount;
import com.epam.webapp.entyti.Region;
import com.epam.webapp.repository.specification.Specification;
import com.epam.webapp.repository.template.Template;
import org.omg.CORBA.OBJ_ADAPTER;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class DiscountRepository extends AbstractRepository<Discount> {

    public DiscountRepository(Connection connection) {
        super(connection);
    }

    @Override
    public List<Discount> query(Specification specification) {
        String query = "select * from discounts " + specification.toSql();
        return execyteQuery(query, new DiscountBuilder(), specification.getParams());
    }

    @Override
    public Optional<Discount> queryForSingleResult(Specification specification) {
        String query = "select * from discounts " + specification.toSql();
        List<Discount> discounts = execyteQuery(query, new DiscountBuilder(), specification.getParams());
        return !discounts.isEmpty() ? Optional.of(discounts.get(0)) : Optional.empty();
    }

    @Override
    public void insert(Template template) {
        throw   new UnsupportedOperationException();
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
