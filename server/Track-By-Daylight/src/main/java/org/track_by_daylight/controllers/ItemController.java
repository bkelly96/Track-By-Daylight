package org.track_by_daylight.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.track_by_daylight.domain.ItemService;
import org.track_by_daylight.domain.OfferingService;
import org.track_by_daylight.models.Item;
import org.track_by_daylight.models.Offering;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @GetMapping
    public List<Item> findAll() {
        return service.findAll();
    }
}