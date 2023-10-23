package org.track_by_daylight.data.mappers;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.track_by_daylight.models.Killer;
import org.track_by_daylight.models.Map;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapMapper implements RowMapper<Map> {

    @Override
    public Map mapRow(ResultSet resultSet, int i) throws SQLException {
        Map map = new Map();
        map.setMapId(resultSet.getInt("map_id"));
        map.setMapName(resultSet.getString("map_name"));
        map.setRealmName(resultSet.getString("realm_name"));
        return map;
    }
}