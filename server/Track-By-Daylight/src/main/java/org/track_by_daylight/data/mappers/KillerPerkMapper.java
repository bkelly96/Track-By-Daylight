package org.track_by_daylight.data.mappers;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.track_by_daylight.models.KillerOffering;
import org.track_by_daylight.models.KillerPerk;
import org.track_by_daylight.models.Perk;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KillerPerkMapper implements RowMapper<KillerPerk> {

    @Override
    public KillerPerk mapRow(ResultSet resultSet, int i) throws SQLException {
        KillerPerk killerPerk = new KillerPerk();
        killerPerk.setKillerPerkId(resultSet.getInt("killer_perk_id"));
        killerPerk.setKillerId(resultSet.getInt("killer_id"));

        PerkMapper perkMapper = new PerkMapper();
        killerPerk.setPerk(perkMapper.mapRow(resultSet, i));

        return killerPerk;
    }
}