package org.track_by_daylight.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.track_by_daylight.data.mappers.SurvivorOfferingMapper;
import org.track_by_daylight.models.SurvivorOffering;

import java.util.List;

@Repository
public class SurvivorOfferingJdbcTemplateRepository implements  SurvivorOfferingRepository {

    private final JdbcTemplate jdbcTemplate;

    public SurvivorOfferingJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<SurvivorOffering> findAll() {

        final String sql = """
                            select so.survivor_offering_id, so.survivor_id, so.offering_id, o.offering_id, o.offering_name
                            from survivor_offering so
                            inner join offering o on so.offering_id = o.offering_id;
                              """;

        return jdbcTemplate.query(sql, new SurvivorOfferingMapper());
    }
}