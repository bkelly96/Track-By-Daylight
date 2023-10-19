package org.track_by_daylight.data.mappers;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.track_by_daylight.models.KillerOffering;
import org.track_by_daylight.models.SurvivorOffering;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KillerOfferingMapper implements RowMapper<KillerOffering> {

    @Override
    public KillerOffering mapRow(ResultSet resultSet, int i) throws SQLException {
        KillerOffering killerOffering = new KillerOffering();
        killerOffering.setKillerOfferingId(resultSet.getInt("killer_offering_id"));
        killerOffering.setKillerId(resultSet.getInt("killer_id"));

        OfferingMapper offeringMapper = new OfferingMapper();
        killerOffering.setOffering(offeringMapper.mapRow(resultSet, i));

        return killerOffering;
    }
}