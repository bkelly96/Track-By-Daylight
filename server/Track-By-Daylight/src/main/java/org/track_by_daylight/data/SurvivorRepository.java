package org.track_by_daylight.data;

import org.track_by_daylight.models.Survivor;

import java.util.List;

public interface SurvivorRepository {
    List<Survivor> findAll();

    List<Survivor> findSurvivorByTrialId(int trialId);
}
