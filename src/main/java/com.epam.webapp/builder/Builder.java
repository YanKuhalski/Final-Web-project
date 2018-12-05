package com.epam.webapp.builder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface Builder<T> {
    public List<T> build(ResultSet set) throws SQLException;
}
