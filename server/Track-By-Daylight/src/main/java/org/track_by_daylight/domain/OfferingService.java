package org.track_by_daylight.domain;

import org.springframework.stereotype.Service;
import org.track_by_daylight.data.OfferingRepository;
import org.track_by_daylight.models.Offering;

import java.util.List;

@Service
public class OfferingService {

    private final OfferingRepository repository;

    public OfferingService(OfferingRepository repository) {
        this.repository = repository;
    }

    public List<Offering> findAll(){ return repository.findAll(); }
}
