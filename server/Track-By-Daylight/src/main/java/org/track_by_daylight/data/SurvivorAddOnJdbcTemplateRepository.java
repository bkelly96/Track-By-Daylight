package org.track_by_daylight.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.track_by_daylight.data.mappers.SurvivorAddOnMapper;
import org.track_by_daylight.models.SurvivorAddOn;

import java.util.List;

@Repository
public class SurvivorAddOnJdbcTemplateRepository implements SurvivorAddOnRepository {

    private final JdbcTemplate jdbcTemplate;

    public SurvivorAddOnJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<SurvivorAddOn> findAll() {

        final String sql = """
                              select sa.survivor_add_on_id, sa.survivor_id, sa.add_on_id, a.add_on_id, a.add_on_name\s
                              from survivor_add_on sa
                              inner join add_on a on sa.add_on_id = a.add_on_id;
                              """;

        return jdbcTemplate.query(sql, new SurvivorAddOnMapper());
    }
}