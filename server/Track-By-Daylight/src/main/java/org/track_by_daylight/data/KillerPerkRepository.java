package org.track_by_daylight.data;

import org.track_by_daylight.models.KillerPerk;

import java.util.List;

public interface KillerPerkRepository {
    List<KillerPerk> findAll();
}
