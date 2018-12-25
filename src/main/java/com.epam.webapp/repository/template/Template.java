package com.epam.webapp.repository.template;

import java.util.List;

public interface Template {
    String toSql();
    List<Object> getValues();
}
