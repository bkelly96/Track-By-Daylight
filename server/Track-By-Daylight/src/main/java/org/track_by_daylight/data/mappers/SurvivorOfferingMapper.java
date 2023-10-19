package org.track_by_daylight.data.mappers;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.track_by_daylight.models.Offering;
import org.track_by_daylight.models.SurvivorOffering;


import java.sql.ResultSet;
import java.sql.SQLException;

public class SurvivorOfferingMapper implements RowMapper<SurvivorOffering> {

    @Override
    public SurvivorOffering mapRow(ResultSet resultSet, int i) throws SQLException {
        SurvivorOffering survivorOffering = new SurvivorOffering();
        survivorOffering.setSurvivorOfferingId(resultSet.getInt("survivor_offering_id"));
        survivorOffering.setSurvivorId(resultSet.getInt("survivor_id"));

        OfferingMapper offeringMapper = new OfferingMapper();
        survivorOffering.setOffering(offeringMapper.mapRow(resultSet, i));

        return survivorOffering;
    }
}