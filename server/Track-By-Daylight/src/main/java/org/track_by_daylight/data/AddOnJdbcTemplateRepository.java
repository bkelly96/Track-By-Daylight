package org.track_by_daylight.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.track_by_daylight.data.mappers.AddOnMapper;
import org.track_by_daylight.models.AddOn;

import java.util.List;

@Repository
public class AddOnJdbcTemplateRepository implements AddOnRepository {

    private final JdbcTemplate jdbcTemplate;

    public AddOnJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<AddOn> findAll() {

        final String sql = "select add_on_id, add_on_name from add_on;";

        return jdbcTemplate.query(sql, new AddOnMapper());
    }

}
