package com.epam.webapp.builder;

import com.epam.webapp.entyti.Discount;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DiscountBuilder implements Builder<Discount> {
    @Override
    public List<Discount> build(ResultSet set) throws SQLException {
        List <Discount> discounts = new ArrayList<>();
        while (set.next()){
            int id = set.getInt(Discount.ID_COLUMN_NAME);
            BigDecimal value = set.getBigDecimal(Discount.VALUE_COLUMN_NAME);
            discounts.add( new Discount(id, value));
        }
        return discounts ;
    }
}
