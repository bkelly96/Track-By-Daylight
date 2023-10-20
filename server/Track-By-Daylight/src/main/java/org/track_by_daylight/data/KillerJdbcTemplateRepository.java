package org.track_by_daylight.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.track_by_daylight.data.mappers.KillerMapper;
import org.track_by_daylight.models.Killer;

import java.util.List;

@Repository
public class KillerJdbcTemplateRepository implements KillerRepository{

    private final JdbcTemplate jdbcTemplate;

    public KillerJdbcTemplateRepository  (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Killer> findAll() {

        final String sql = """
                select killer_id, killer_name, is_player, trial_id from killer;
                              """;

        return jdbcTemplate.query(sql, new KillerMapper());
    }




}
