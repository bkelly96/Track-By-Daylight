package org.track_by_daylight.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.track_by_daylight.data.mappers.KillerAddOnMapper;
import org.track_by_daylight.data.mappers.KillerPerkMapper;
import org.track_by_daylight.models.KillerAddOn;

import java.util.List;

@Repository
public class KillerAddOnJdbcTemplateRepository implements KillerAddOnRepository {

    private final JdbcTemplate jdbcTemplate;

    public KillerAddOnJdbcTemplateRepository  (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<KillerAddOn> findAll() {

        final String sql = """
                select ka.killer_add_on_id, ka.killer_id, ka.add_on_id, a.add_on_id, a.add_on_name\s
                from killer_add_on ka
                inner join add_on a on ka.add_on_id = a.add_on_id;
                              """;

        return jdbcTemplate.query(sql, new KillerAddOnMapper());
    }
}