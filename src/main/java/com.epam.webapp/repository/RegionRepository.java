package com.epam.webapp.repository;

import com.epam.webapp.builder.RegionBuilder;
import com.epam.webapp.entyti.Region;
import com.epam.webapp.entyti.enums.OperationType;
import com.epam.webapp.exception.RepositoryException;
import com.epam.webapp.repository.specification.Specification;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class RegionRepository extends AbstractRepository<Region> {
    private static final String SQL = "select * from regions ";
    private static final String UPDATE_SQL = "update regions set ";
    private static final String INSERT_SQL = "insert into regions ";

    public RegionRepository(Connection connection) {
        super(connection);
    }

    @Override
    public List<Region> query(Specification specification) throws RepositoryException {
        String query = SQL + specification.toSql();
        return executeQuery(query, new RegionBuilder(), specification.getParams());
    }

    @Override
    public Optional<Region> queryForSingleResult(Specification specification) throws RepositoryException {
        String query = SQL + specification.toSql();
        List<Region> regions = executeQuery(query, new RegionBuilder(), specification.getParams());
        return !regions.isEmpty() ? Optional.of(regions.get(0)) : Optional.empty();
    }

    @Override
    protected String toSql(OperationType operationType) {
        if (operationType == OperationType.INSERT){
            return  INSERT_SQL;
        }else {
            return UPDATE_SQL;
        }
    }

    @Override
    protected Map<String, Object> makeMap(Region item) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected List<Object> getParams(Map<String, Object> map) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Specification specification) {
        throw   new UnsupportedOperationException();
    }
}
