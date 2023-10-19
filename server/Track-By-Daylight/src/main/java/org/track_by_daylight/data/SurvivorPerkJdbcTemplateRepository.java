package org.track_by_daylight.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.track_by_daylight.data.mappers.SurvivorPerkMapper;
import org.track_by_daylight.models.SurvivorPerk;

import java.util.List;

@Repository

public class SurvivorPerkJdbcTemplateRepository implements SurvivorPerkRepository {

    private final JdbcTemplate jdbcTemplate;

    public SurvivorPerkJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<SurvivorPerk> findAll() {

        final String sql = """
                select sp.survivor_perk_id, sp.survivor_id, sp.perk_id, p.perk_id, p.perk_name\s
                from survivor_perk sp
                inner join perk p on sp.perk_id = p.perk_id;
                              """;

        return jdbcTemplate.query(sql, new SurvivorPerkMapper());
    }
}