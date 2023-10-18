package org.track_by_daylight.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.track_by_daylight.data.mappers.OfferingMapper;
import org.track_by_daylight.models.Offering;

import java.util.List;

@Repository
public class OfferingJdbcTemplateRepository implements OfferingRepository{

    private final JdbcTemplate jdbcTemplate;


    public OfferingJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Offering> findAll(){
        final String sql = """
                select offering_id, offering_name from offering;
                """;

        return jdbcTemplate.query(sql, new OfferingMapper());
    }

}
