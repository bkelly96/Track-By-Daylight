package org.track_by_daylight.data;

import org.track_by_daylight.models.Killer;
import org.track_by_daylight.models.Trial;

import java.util.List;

public interface TrialRepository {
    List<Trial> findAll();
}
