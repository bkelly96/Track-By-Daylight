package org.track_by_daylight.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.track_by_daylight.data.mappers.TrialMapper;
import org.track_by_daylight.models.Trial;

import java.util.List;

@Repository
public class TrialJdbcTemplateRepository implements TrialRepository {

    private final JdbcTemplate jdbcTemplate;

    public TrialJdbcTemplateRepository (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Trial> findAll() {

        final String sql = """
                select t.trial_id, t.date, t.salt, t.app_user_id, m.map_id, m.map_name, m.realm_name
                from trial t\s
                inner join map m on m.map_id = t.map_id;
                              """;

        return jdbcTemplate.query(sql, new TrialMapper());
    }

    @Override
    public List<Trial> findByUserId(int userId){
        final String sql = """
                select t.trial_id, t.date, t.salt, t.app_user_id, m.map_id, m.map_name, m.realm_name
                from trial t\s
                inner join map m on m.map_id = t.map_id
                where t.app_user_id = ?;
                              """;

        return jdbcTemplate.query(sql, new TrialMapper(), userId);
    }

    @Override
    public List<Trial> findByUsername(String username){
        final String sql = """
                select u.username, t.trial_id, t.date, t.salt, t.app_user_id, m.map_id, m.map_name, m.realm_name
                from trial t\s
                inner join map m on m.map_id = t.map_id
                inner join app_user u on u.app_user_id = t.app_user_id
                where u.username = ?;
                              """;

        return jdbcTemplate.query(sql, new TrialMapper(), username);
    }

}

