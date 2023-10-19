package org.track_by_daylight.data;

import org.track_by_daylight.models.KillerAddOn;

import java.util.List;

public interface KillerAddOnRepository {
    List<KillerAddOn> findAll();
}
