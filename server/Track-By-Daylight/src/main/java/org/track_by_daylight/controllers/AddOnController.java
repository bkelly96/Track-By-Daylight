package org.track_by_daylight.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.track_by_daylight.domain.AddOnService;
import org.track_by_daylight.domain.OfferingService;
import org.track_by_daylight.models.AddOn;
import org.track_by_daylight.models.Offering;

import java.util.List;

@RestController
@RequestMapping("/api/addons")
public class AddOnController {

    private final AddOnService service;

    public AddOnController(AddOnService service) {
        this.service = service;
    }

    @GetMapping
    public List<AddOn> findAll() {
        return service.findAll();
    }
}