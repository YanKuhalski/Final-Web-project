package com.epam.webapp.repository.specification;

import com.sun.deploy.security.BlacklistedCerts;

import java.util.List;

public interface Specification {
    String toSql();

    List<Object> getParams();
}
