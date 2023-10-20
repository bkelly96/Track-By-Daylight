package org.track_by_daylight.data;

import org.track_by_daylight.models.Map;

import java.util.List;

public interface MapRepository {
    List<Map> findAll();
}
