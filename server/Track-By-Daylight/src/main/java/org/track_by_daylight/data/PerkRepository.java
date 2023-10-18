package org.track_by_daylight.data;

import org.track_by_daylight.models.Perk;

import java.util.List;

public interface PerkRepository {
    List<Perk> findAll();
}
