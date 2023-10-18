package org.track_by_daylight.data.mappers;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.track_by_daylight.models.Offering;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OfferingMapper implements RowMapper<Offering> {

    @Override
    public Offering mapRow(ResultSet resultSet, int i) throws SQLException {
        Offering offering = new Offering();
        offering.setOfferingId(resultSet.getInt("offering_id"));
        offering.setOfferingName(resultSet.getString("offering_name"));
        return offering;
    }
}
