package org.track_by_daylight.data.mappers;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.track_by_daylight.models.Killer;
import org.track_by_daylight.models.KillerPerk;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KillerMapper  implements RowMapper<Killer> {

    @Override
    public Killer mapRow(ResultSet resultSet, int i) throws SQLException {
        Killer killer = new Killer();
        killer.setKillerId(resultSet.getInt("killer_id"));
        killer.setKillerName(resultSet.getString("killer_name"));
        killer.setPlayer(resultSet.getBoolean("is_player"));

        TrialMapper trialMapper = new TrialMapper();
        killer.setTrial(trialMapper.mapRow(resultSet, i));

        return killer;
    }
}