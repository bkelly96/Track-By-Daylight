package org.track_by_daylight.data.mappers;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.track_by_daylight.models.KillerAddOn;
import org.track_by_daylight.models.KillerPerk;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KillerAddOnMapper implements RowMapper<KillerAddOn> {

    @Override
    public KillerAddOn mapRow(ResultSet resultSet, int i) throws SQLException {
        KillerAddOn killerAddOn = new KillerAddOn();
        killerAddOn.setKillerAddOnId(resultSet.getInt("killer_add_on_id"));
        killerAddOn.setKillerId(resultSet.getInt("killer_id"));

        AddOnMapper addOnMapper = new AddOnMapper();
        killerAddOn.setAddOn(addOnMapper.mapRow(resultSet, i));

        return killerAddOn;
    }
}