package org.aguprasath.moiapp.controller;

import org.aguprasath.moiapp.dto.EventDTO;
import org.aguprasath.moiapp.model.Contribution;
import org.aguprasath.moiapp.model.Event;
import org.aguprasath.moiapp.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("event")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/all")
    public ResponseEntity<List<Event>> getAllEvents() {
        return new ResponseEntity<>(eventService.getAllEvents(),HttpStatus.OK);
    }

    @PutMapping("{eventId}/update")
    public ResponseEntity<EventDTO> updateEvent(@PathVariable Long eventId , @RequestBody Event event) {
        Event newEvent=eventService.addEvent(event);
        EventDTO eventDTO=eventService.mapToEventDTO(newEvent);
        return new ResponseEntity<>(eventDTO,HttpStatus.OK);
    }
    @PostMapping("add")
    public ResponseEntity<EventDTO> addEvent(@RequestBody Event event) {
        Event newEvent=eventService.addEvent(event);
        EventDTO eventDTO=eventService.mapToEventDTO(newEvent);
        return new ResponseEntity<>(eventDTO,HttpStatus.CREATED);
    }


    @DeleteMapping("/{eventId}/delete")
    public ResponseEntity<String> deleteEvent(@PathVariable Long eventId) {
        return new ResponseEntity<>(eventService.deleteEvent(eventId),HttpStatus.OK);
    }

}
