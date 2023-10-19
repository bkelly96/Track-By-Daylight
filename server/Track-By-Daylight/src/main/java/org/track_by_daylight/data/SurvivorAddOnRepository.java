package org.track_by_daylight.data;

import org.track_by_daylight.models.SurvivorAddOn;

import java.util.List;

public interface SurvivorAddOnRepository {
    List<SurvivorAddOn> findAll();
}
