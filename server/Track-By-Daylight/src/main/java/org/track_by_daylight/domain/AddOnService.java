package org.track_by_daylight.domain;

import org.springframework.stereotype.Service;
import org.track_by_daylight.data.AddOnRepository;
import org.track_by_daylight.models.AddOn;
import org.track_by_daylight.models.Offering;

import java.util.List;

@Service
public class AddOnService {

    private final AddOnRepository repository;

    public AddOnService(AddOnRepository repository) {
        this.repository = repository;
    }

    public List<AddOn> findAll(){ return repository.findAll(); }
}
