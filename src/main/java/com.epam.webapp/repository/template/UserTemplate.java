package com.epam.webapp.repository.template;

import java.util.List;

public class UserTemplate  implements  Template{
    @Override
    public String toSql() {
        throw  new UnsupportedOperationException();
    }

    @Override
    public List<Object> getValues() {
        throw  new UnsupportedOperationException();
    }
}
