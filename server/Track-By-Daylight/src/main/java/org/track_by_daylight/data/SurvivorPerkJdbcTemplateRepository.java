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

    @Override
    public List<SurvivorPerk> findPerkBySurvivorId(int survivorId){

        final String sql = """
                select s.survivor_id, s.survivor_name, s.survive, s.is_player, s.trial_id, sp.survivor_perk_id, sp.survivor_id, sp.perk_id, p.perk_id, p.perk_name 
                from survivor s
                inner join survivor_perk sp on s.survivor_id = sp.survivor_id
                inner join perk p on sp.perk_id = p.perk_id
                where s.survivor_id = ?;
                """;

        return jdbcTemplate.query(sql, new SurvivorPerkMapper(), survivorId);
    }
}