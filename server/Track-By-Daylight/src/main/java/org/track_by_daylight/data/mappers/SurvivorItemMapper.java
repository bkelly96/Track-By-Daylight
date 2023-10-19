package org.track_by_daylight.data.mappers;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.track_by_daylight.models.SurvivorItem;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SurvivorItemMapper implements RowMapper<SurvivorItem> {

    @Override
    public SurvivorItem mapRow(ResultSet resultSet, int i) throws SQLException {
        SurvivorItem survivorItem = new SurvivorItem();
        survivorItem.setSurvivorItemId(resultSet.getInt("survivor_item_id"));
        survivorItem.setSurvivorId(resultSet.getInt("survivor_id"));

        ItemMapper itemMapper = new ItemMapper();
        survivorItem.setItem(itemMapper.mapRow(resultSet, i));

        return survivorItem;
    }
}
