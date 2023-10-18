package org.track_by_daylight.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.track_by_daylight.data.mappers.PerkMapper;
import org.track_by_daylight.models.Perk;

import java.util.List;

@Repository
public class PerkJdbcTemplateRepository implements PerkRepository{

    private final JdbcTemplate jdbcTemplate;

    public PerkJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Perk> findAll() {

        final String sql = "select perk_id, perk_name from perk;";

        return jdbcTemplate.query(sql, new PerkMapper());
    }
}
