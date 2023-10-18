package org.track_by_daylight.data;

import org.track_by_daylight.models.Offering;

import java.util.List;

public interface OfferingRepository {
    List<Offering> findAll();
}