package org.track_by_daylight.data;

import org.track_by_daylight.models.AddOn;

import java.util.List;

public interface AddOnRepository {
    List<AddOn> findAll();
}
