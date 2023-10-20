package org.track_by_daylight.data;

import org.springframework.stereotype.Repository;
import org.track_by_daylight.models.Killer;

import java.util.List;

public interface KillerRepository {
    List<Killer> findAll();
}
