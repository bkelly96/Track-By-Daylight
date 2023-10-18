package org.track_by_daylight.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.track_by_daylight.data.mappers.ItemMapper;
import org.track_by_daylight.models.Item;
import org.track_by_daylight.models.Offering;

import java.util.List;

@Repository
public class ItemJdbcTemplateRepository implements ItemRepository{

    private final JdbcTemplate jdbcTemplate;


    public ItemJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Item> findAll(){
        final String sql = """
                select item_id, item_name from item;
                """;

        return jdbcTemplate.query(sql, new ItemMapper());
    }
}
