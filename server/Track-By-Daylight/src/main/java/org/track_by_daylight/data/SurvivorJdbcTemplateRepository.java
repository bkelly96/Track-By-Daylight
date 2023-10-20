package org.track_by_daylight.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.track_by_daylight.data.mappers.KillerMapper;
import org.track_by_daylight.data.mappers.SurvivorMapper;
import org.track_by_daylight.models.Survivor;

import java.util.List;

@Repository
public class SurvivorJdbcTemplateRepository implements SurvivorRepository {

    private final JdbcTemplate jdbcTemplate;

    public SurvivorJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Survivor> findAll() {

        final String sql = """
                select survivor_id, survivor_name, is_player, trial_id from survivor;
                              """;

        return jdbcTemplate.query(sql, new SurvivorMapper());
    }
}

