package org.aguprasath.moiapp.service;

import org.aguprasath.moiapp.dao.EventRepo;
import org.aguprasath.moiapp.dto.EventDTO;
import org.aguprasath.moiapp.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepo eventRepo;

    public List<Event> getAllEvents() {
        return eventRepo.findAll();
    }
    public Event addEvent(Event event) {
        return eventRepo.save(event);
    }

    public Optional<Event> getEventById(long id) {
        return eventRepo.findById(id);
    }

    public String deleteEvent(Long eventId) {
        Optional<Event> event= eventRepo.findById(eventId);

        if(event.isPresent()){
            eventRepo.delete(event.get());
            return "Event deleted";
        }
        return "Event not found";

    }

    public EventDTO mapToEventDTO(Event event) {
        return new EventDTO(
                event.getId(),
                event.getName(),
                event.getDescription(),
                event.getEventDate()
        );
    }

}
