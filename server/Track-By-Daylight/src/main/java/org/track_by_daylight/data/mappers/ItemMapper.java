package org.track_by_daylight.data.mappers;

import org.springframework.jdbc.core.RowMapper;
import org.track_by_daylight.models.Item;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemMapper implements RowMapper<Item> {

    @Override
    public Item mapRow(ResultSet resultSet, int i) throws SQLException {
        Item item = new Item();
        item.setItemId(resultSet.getInt("item_id"));
        item.setItemName(resultSet.getString("item_name"));
        return item;
    }
}
