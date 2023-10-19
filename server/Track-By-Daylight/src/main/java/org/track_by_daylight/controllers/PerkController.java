package org.track_by_daylight.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.track_by_daylight.domain.OfferingService;
import org.track_by_daylight.domain.PerkService;
import org.track_by_daylight.models.Offering;
import org.track_by_daylight.models.Perk;

import java.util.List;

@RestController
@RequestMapping("/api/perks")
public class PerkController {

    private final PerkService service;

    public PerkController(PerkService service) {
        this.service = service;
    }

    @GetMapping
    public List<Perk> findAll() {
        return service.findAll();
    }
}