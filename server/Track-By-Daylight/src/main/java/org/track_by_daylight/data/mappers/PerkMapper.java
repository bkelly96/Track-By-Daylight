package org.track_by_daylight.data.mappers;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import org.track_by_daylight.models.Perk;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PerkMapper implements RowMapper<Perk> {

    @Override
    public Perk mapRow(ResultSet resultSet, int i) throws SQLException {
        Perk perk = new Perk();
        perk.setPerkId(resultSet.getInt("perk_id"));
        perk.setPerkName(resultSet.getString("perk_name"));
        return perk;
    }
}
