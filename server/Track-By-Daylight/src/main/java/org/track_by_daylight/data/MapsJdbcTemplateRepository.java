package org.track_by_daylight.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.track_by_daylight.data.mappers.MapMapper;
import org.track_by_daylight.models.Map;

import java.util.List;

@Repository
public class MapsJdbcTemplateRepository implements MapRepository {

    private final JdbcTemplate jdbcTemplate;

    public MapsJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Map> findAll() {

        final String sql = """
                select map_id, map_name, realm_name, trial_id from map;
                              """;

        return jdbcTemplate.query(sql, new MapMapper());
    }
}