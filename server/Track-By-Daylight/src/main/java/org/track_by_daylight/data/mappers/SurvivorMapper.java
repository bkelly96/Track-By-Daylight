package org.track_by_daylight.data.mappers;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.track_by_daylight.models.Killer;
import org.track_by_daylight.models.Survivor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SurvivorMapper implements RowMapper<Survivor> {

    @Override
    public Survivor mapRow(ResultSet resultSet, int i) throws SQLException {
        Survivor survivor = new Survivor();
        survivor.setSurvivorId(resultSet.getInt("survivor_id"));
        survivor.setSurvivorName(resultSet.getString("survivor_name"));
        survivor.setPlayer(resultSet.getBoolean("is_player"));
        survivor.setTrialId(resultSet.getInt("trial_id"));

        return survivor;
    }
}