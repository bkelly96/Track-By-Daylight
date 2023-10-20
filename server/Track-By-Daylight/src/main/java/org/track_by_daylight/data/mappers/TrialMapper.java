package org.track_by_daylight.data.mappers;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.track_by_daylight.models.Trial;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TrialMapper implements RowMapper<Trial> {

@Override
public Trial mapRow(ResultSet resultSet, int i) throws SQLException {
        Trial trial = new Trial();
        trial.setTrialId(resultSet.getInt("trial_id"));
        trial.setDate(resultSet.getDate("date"));
        trial.setSalt(resultSet.getBoolean("salt"));
        return trial;
        }
}