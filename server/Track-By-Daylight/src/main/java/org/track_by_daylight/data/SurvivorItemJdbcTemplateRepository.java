package org.track_by_daylight.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.track_by_daylight.data.mappers.SurvivorItemMapper;
import org.track_by_daylight.models.SurvivorAddOn;
import org.track_by_daylight.models.SurvivorItem;

import java.util.List;

@Repository
public class SurvivorItemJdbcTemplateRepository implements SurvivorItemRepository {

    private final JdbcTemplate jdbcTemplate;

    public SurvivorItemJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<SurvivorItem> findAll() {

        final String sql = """
                select si.survivor_item_id, si.survivor_id, si.item_id, i.item_id, i.item_name\s
                from survivor_item si
                inner join item i on si.survivor_item_id = i.item_id;
                              """;

        return jdbcTemplate.query(sql, new SurvivorItemMapper());
    }
}