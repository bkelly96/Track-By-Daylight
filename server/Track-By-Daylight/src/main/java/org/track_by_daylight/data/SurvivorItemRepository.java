package org.track_by_daylight.data;

import org.track_by_daylight.models.SurvivorItem;

import java.util.List;

public interface SurvivorItemRepository {
    List<SurvivorItem> findAll();
}
