package org.track_by_daylight.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.track_by_daylight.data.mappers.KillerMapper;
import org.track_by_daylight.data.mappers.SurvivorMapper;
import org.track_by_daylight.data.mappers.TrialMapper;
import org.track_by_daylight.models.Survivor;
import org.track_by_daylight.models.Trial;

import java.util.List;

@Repository
public class TrialJdbcTemplateRepository implements TrialRepository {

    private final JdbcTemplate jdbcTemplate;

    public TrialJdbcTemplateRepository (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Trial> findAll() {

        final String sql = """
                select trial_id, date, salt, app_user_id from trial;
                              """;

        return jdbcTemplate.query(sql, new TrialMapper());
    }
}

