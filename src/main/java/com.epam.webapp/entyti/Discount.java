package com.epam.webapp.entyti;

import com.epam.webapp.repository.template.Template;

import java.math.BigDecimal;
import java.util.List;

public class Discount implements Template {
    public static String ID_COLUMN_NAME = "id";
    public static String VALUE_COLUMN_NAME = "value";
    private int id;
    private BigDecimal value;

    public Discount(int id, BigDecimal value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public String toSql() {
        throw  new UnsupportedOperationException();
    }

    @Override
    public List<Object> getValues() {
        throw  new UnsupportedOperationException();
    }
}
