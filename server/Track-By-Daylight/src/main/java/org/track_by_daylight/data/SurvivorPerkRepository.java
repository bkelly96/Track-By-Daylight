package org.track_by_daylight.data;

import org.track_by_daylight.models.SurvivorPerk;

import java.util.List;

public interface SurvivorPerkRepository {
    List<SurvivorPerk> findAll();
}
