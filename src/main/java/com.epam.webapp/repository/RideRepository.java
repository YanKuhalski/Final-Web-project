package com.epam.webapp.repository;

import com.epam.webapp.builder.RideBuilder;
import com.epam.webapp.entyti.Ride;
import com.epam.webapp.entyti.enums.OperationType;
import com.epam.webapp.exception.RepositoryException;
import com.epam.webapp.repository.specification.Specification;

import java.sql.Connection;
import java.util.*;

public class RideRepository extends AbstractRepository<Ride> {
    private static final String SQL = "select * from  rides " +
            "inner join users client on rides.client_id  = client.id " +
            "inner join users driver on rides.driver_id  = driver.id " +
            "inner join cars car on rides.car_id  = car.id " +
            "inner join regions sregion on rides.start_region_id  = sregion.id " +
            "inner join regions eregion on rides.end_region_id  = eregion.id ";
    private static final String INSERT_SQL = "insert into rides ";
    private static final String UPDATE_SQL = "update rides set ";

    public RideRepository(Connection connection) {
        super(connection);
    }

    @Override
    public List<Ride> query(Specification specification) throws RepositoryException {
        String query = SQL + specification.toSql();
        List<Ride> rides = executeQuery(query, new RideBuilder(), specification.getParams());
        return rides;
    }

    @Override
    public Optional<Ride> queryForSingleResult(Specification specification) throws RepositoryException {
        String query = SQL + specification.toSql();
        List<Ride> ride = executeQuery(query, new RideBuilder(), specification.getParams());
        return !ride.isEmpty() ? Optional.of(ride.get(0)) : Optional.empty();
    }


    @Override
    public void delete(Specification specification) throws RepositoryException {
        String sql = " delete from rides where " + specification.toSql();
        executeUpdate(sql, specification.getParams());
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
    protected Map<String, Object> makeMap(Ride ride) {
        Map<String, Object> map = new HashMap<>();
        map.put("client_id",ride.getClientId());
        map.put("driver_id",ride.getDriverId());
        map.put("car_id",ride.getCarId());
        map.put("start_region_id",ride.getStartRegionId());
        map.put("end_region_id",ride.getEndRegionId());
        return map;
    }

}
