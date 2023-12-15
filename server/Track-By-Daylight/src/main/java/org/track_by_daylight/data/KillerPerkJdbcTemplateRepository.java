package org.track_by_daylight.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.track_by_daylight.data.mappers.KillerPerkMapper;
import org.track_by_daylight.data.mappers.SurvivorPerkMapper;
import org.track_by_daylight.models.KillerPerk;

import java.util.List;

@Repository
public class KillerPerkJdbcTemplateRepository implements KillerPerkRepository {

    private final JdbcTemplate jdbcTemplate;

    public KillerPerkJdbcTemplateRepository  (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<KillerPerk> findAll() {

        final String sql = """
                select kp.killer_perk_id, kp.killer_id, kp.perk_id, p.perk_id, p.perk_name\s
                from killer_perk kp
                inner join perk p on kp.perk_id = p.perk_id;
                              """;

        return jdbcTemplate.query(sql, new KillerPerkMapper());
    }

    @Override
    public List<KillerPerk> findPerkByKillerId(int killerId) {

        final String sql = """
                select k.killer_id, k.killer_name, k.is_player, k.trial_id, kp.killer_perk_id, kp.killer_id, kp.perk_id, p.perk_id, p.perk_name\s
                from killer k
                inner join killer_perk kp on k.killer_id = kp.killer_id
                inner join perk p on kp.perk_id = p.perk_id
                where k.killer_id = ?;
                """;

        return jdbcTemplate.query(sql, new KillerPerkMapper(), killerId);
    }

}