package org.track_by_daylight.data.mappers;

import org.springframework.jdbc.core.RowMapper;
import org.track_by_daylight.models.Offering;
import org.track_by_daylight.models.SurvivorAddOn;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SurvivorAddOnMapper implements RowMapper<SurvivorAddOn> {

    @Override
    public SurvivorAddOn mapRow(ResultSet resultSet, int i) throws SQLException {
        SurvivorAddOn survivorAddOn = new SurvivorAddOn();
        survivorAddOn.setSurvivorAddOnId(resultSet.getInt("survivor_add_on_id"));
        survivorAddOn.setSurvivorId(resultSet.getInt("survivor_id"));

        AddOnMapper addOnMapper = new AddOnMapper();
        survivorAddOn.setAddOn(addOnMapper.mapRow(resultSet, i));

        return survivorAddOn;
    }
}
