package org.track_by_daylight.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.track_by_daylight.data.mappers.KillerOfferingMapper;
import org.track_by_daylight.data.mappers.SurvivorAddOnMapper;
import org.track_by_daylight.models.KillerOffering;
import org.track_by_daylight.models.SurvivorAddOn;

import java.util.List;

@Repository
public class KillerOfferingJdbcTemplateRepository implements KillerOfferingRepository {

    private final JdbcTemplate jdbcTemplate;

    public KillerOfferingJdbcTemplateRepository (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<KillerOffering> findAll() {

        final String sql = """
                    select ko.killer_offering_id, ko.killer_id, ko.offering_id, o.offering_id, o.offering_name
                    from killer_offering ko
                    inner join offering o on ko.offering_id = o.offering_id;
                              """;

        return jdbcTemplate.query(sql, new KillerOfferingMapper());
    }
}