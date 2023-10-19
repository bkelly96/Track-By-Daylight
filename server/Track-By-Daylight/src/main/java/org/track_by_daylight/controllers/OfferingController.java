package org.track_by_daylight.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.track_by_daylight.domain.OfferingService;
import org.track_by_daylight.models.Offering;

import java.util.List;

@RestController
@RequestMapping("/api/offerings")
public class OfferingController {

    private final OfferingService service;

    public OfferingController(OfferingService service) {
        this.service = service;
    }

    @GetMapping
    public List<Offering> findAll() {
        return service.findAll();
    }
}
