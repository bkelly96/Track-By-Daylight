package org.track_by_daylight.domain;

import org.springframework.stereotype.Service;
import org.track_by_daylight.data.KillerAddOnRepository;
import org.track_by_daylight.data.KillerOfferingRepository;
import org.track_by_daylight.models.KillerAddOn;
import org.track_by_daylight.models.KillerOffering;

import java.util.List;

@Service
public class KillerOfferingService {

    private final KillerOfferingRepository repository;

    public  KillerOfferingService( KillerOfferingRepository repository) {
        this.repository = repository;
    }

    public List<KillerOffering> findAll() {return repository.findAll(); }
}
