package org.track_by_daylight.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.track_by_daylight.domain.KillerPerkService;
import org.track_by_daylight.domain.PerkService;
import org.track_by_daylight.domain.SurvivorPerkService;
import org.track_by_daylight.models.KillerPerk;
import org.track_by_daylight.models.Perk;
import org.track_by_daylight.models.SurvivorPerk;

import java.util.List;

@RestController
@RequestMapping("/api/perks")
public class PerkController {

    private final PerkService service;

    private final SurvivorPerkService spService;
    private final KillerPerkService kpService;

    public PerkController(PerkService service, SurvivorPerkService spService, KillerPerkService kpService) {
        this.service = service;
        this.spService = spService;
        this.kpService = kpService;
    }

    @GetMapping
    public List<Perk> findAll() {
        return service.findAll();
    }

    @GetMapping ("/survivor/{survivorId}")
    public List<SurvivorPerk> findPerkBySurvivorId(@PathVariable int survivorId){
        return spService.findPerkBySurvivorId(survivorId);
    }

    @GetMapping("/killer/{killerId}")
    public List<KillerPerk> findPerkByKillerId(@PathVariable int killerId){
        return kpService.findPerkByKillerId(killerId);
    }

}