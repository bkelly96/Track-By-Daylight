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
                select k.killer_id, k.killer_name, k.is_player, k.trial_id, t.trial_id, t.date, t.salt, t.app_user_id, m.map_id, m.map_name, m.realm_name
                from killer k
                inner join trial t on k.trial_id = t.trial_id
                inner join map m on m.map_id = t.map_id
                              """;

        return jdbcTemplate.query(sql, new KillerMapper());
    }

    @Override
    public List<Killer> findKillerByTrialId(int trialId){

        final String sql = """
                select k.killer_id, k.killer_name, k.is_player, k.trial_id, t.trial_id, t.date, t.salt, t.app_user_id, m.map_id, m.map_name, m.realm_name
                from killer k
                inner join trial t on k.trial_id = t.trial_id
                inner join map m on m.map_id = t.map_id
                where k.trial_id = ?;
                """;

        return jdbcTemplate.query(sql, new KillerMapper(), trialId);

    }


}
