package org.aguprasath.moiapp.controller;

import org.aguprasath.moiapp.model.Event;
import org.aguprasath.moiapp.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    @RequestMapping("/allEvents")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @PutMapping("updateEvent/{eventId}")
    public Event updateEvent(@PathVariable Long eventId , @RequestBody Event event) {
        return eventService.addEvent(event);
    }
    @PostMapping("addEvent")
    public Event addEvent(@RequestBody Event event) {
        return eventService.addEvent(event);
    }
}
