package org.track_by_daylight.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.track_by_daylight.domain.PerkService;
import org.track_by_daylight.domain.SurvivorPerkService;
import org.track_by_daylight.models.Perk;
import org.track_by_daylight.models.SurvivorPerk;

import java.util.List;

@RestController
@RequestMapping("/api/perks")
public class PerkController {

    private final PerkService service;

    private final SurvivorPerkService spService;

    public PerkController(PerkService service, SurvivorPerkService spService) {
        this.service = service;
        this.spService = spService;
    }

    @GetMapping
    public List<Perk> findAll() {
        return service.findAll();
    }

    @GetMapping ("/survivor/{survivorId}")
    public List<SurvivorPerk> findByPerkBySurvivorId(@PathVariable int survivorId){
        return spService.findPerkBySurvivorId(survivorId);
    }
}