package org.track_by_daylight.data.mappers;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.track_by_daylight.models.SurvivorPerk;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SurvivorPerkMapper implements RowMapper<SurvivorPerk> {

    @Override
    public SurvivorPerk mapRow(ResultSet resultSet, int i) throws SQLException {
        SurvivorPerk survivorPerk = new SurvivorPerk();
        survivorPerk.setSurvivorPerkId(resultSet.getInt("survivor_perk_id"));
        survivorPerk.setSurvivorId(resultSet.getInt("survivor_id"));

        PerkMapper perkMapper = new PerkMapper();
        survivorPerk.setPerk(perkMapper.mapRow(resultSet, i));

        return survivorPerk;
    }
}