package com.epam.webapp.builder;

import com.epam.webapp.entyti.Identifiable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface Builder<T extends Identifiable> {
    T build(ResultSet set) throws SQLException;
}
