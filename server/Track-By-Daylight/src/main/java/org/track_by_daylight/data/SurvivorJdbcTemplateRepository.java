package org.track_by_daylight.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.track_by_daylight.data.mappers.SurvivorMapper;
import org.track_by_daylight.models.Survivor;

import java.util.List;

@Repository
public class SurvivorJdbcTemplateRepository implements SurvivorRepository {

    private final JdbcTemplate jdbcTemplate;

    public SurvivorJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Survivor> findAll() {

        final String sql = """
                select s.survivor_id, s.survivor_name, s.survive, s.is_player, s.trial_id, t.trial_id, t.date, t.salt, t.app_user_id, m.map_id, m.map_name, m.realm_name
                from survivor s
                inner join trial t on s.trial_id = t.trial_id
                inner join map m on m.map_id = t.map_id;    
                              """;

        return jdbcTemplate.query(sql, new SurvivorMapper());
    }

    @Override
    public List<Survivor> findSurvivorByTrialId(int trialId){

        final String sql = """
                select s.survivor_id, s.survivor_name, s.survive, s.is_player, s.trial_id, t.trial_id, t.date, t.salt, t.app_user_id, m.map_id, m.map_name, m.realm_name
                from survivor s
                inner join trial t on s.trial_id = t.trial_id
                inner join map m on m.map_id = t.map_id
                where s.trial_id = ?;
                """;

        return jdbcTemplate.query(sql, new SurvivorMapper(), trialId);

    }

}

