package org.track_by_daylight.domain;

import org.springframework.stereotype.Service;
import org.track_by_daylight.data.KillerRepository;
import org.track_by_daylight.data.MapRepository;
import org.track_by_daylight.models.Killer;
import org.track_by_daylight.models.Map;

import java.util.List;

@Service
public class MapService {

    private final MapRepository repository;

    public MapService(MapRepository repository) {
        this.repository = repository;
    }

    public List<Map> findAll() {return repository.findAll(); }
}
