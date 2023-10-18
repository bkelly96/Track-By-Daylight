package org.track_by_daylight.data.mappers;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.track_by_daylight.models.AddOn;
import org.track_by_daylight.models.AppUser;
import org.track_by_daylight.models.Perk;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AddOnMapper implements RowMapper<AddOn> {

    @Override
    public AddOn mapRow(ResultSet resultSet, int i) throws SQLException {
        AddOn addOn = new AddOn();
        addOn.setAddOnId(resultSet.getInt("add_on_id"));
        addOn.setAddOnName(resultSet.getString("add_on_name"));
        return addOn;
    }
}