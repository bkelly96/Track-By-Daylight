package org.track_by_daylight.data;

import org.track_by_daylight.models.SurvivorOffering;

import java.util.List;

public interface SurvivorOfferingRepository {
    List<SurvivorOffering> findAll();
}
