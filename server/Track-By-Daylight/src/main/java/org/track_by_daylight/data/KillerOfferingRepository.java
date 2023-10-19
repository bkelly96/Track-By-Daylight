package org.track_by_daylight.data;

import org.track_by_daylight.models.KillerOffering;
import org.track_by_daylight.models.SurvivorAddOn;

import java.util.List;

public interface KillerOfferingRepository {
    List<KillerOffering> findAll();
}
