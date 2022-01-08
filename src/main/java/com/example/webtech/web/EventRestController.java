package com.example.webtech.web;


import com.example.webtech.persistance.Event;
import com.example.webtech.persistance.EventManipulationRequest;
import com.example.webtech.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class EventRestController {

    private final EventService eventService;

    public EventRestController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping(path = "/events")
    public ResponseEntity<Void> createPerson(@RequestBody EventManipulationRequest request) throws URISyntaxException {
        var valid = validate(request);
        if (valid) {
        Event event = eventService.create(request);
        URI uri = new URI("/events/" + event.getId());
        return ResponseEntity.created(uri).build();}

        else{
            return ResponseEntity.badRequest().build();
        }

    }

    @GetMapping(path = "/events")
    public ResponseEntity<List<Event>> fetchEvents() {
        return ResponseEntity.ok(eventService.findAll());
    }

    @GetMapping(path = "/eventstoday")
    public ResponseEntity<List<Event>> fetchEventstoday() {
        return ResponseEntity.ok(eventService.findEventstoday());
    }

    @GetMapping(path = "/events/{id}")
    public ResponseEntity<Event> fetchEventById(@PathVariable Long id) {
        Event event = eventService.findById(id);
        if (event !=null) {return ResponseEntity.ok(event);}
        else {return ResponseEntity.notFound().build();}

    }

    @PutMapping(path = "/events/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody EventManipulationRequest request) {
        Event event =eventService.update(id, request);
        if (event !=null) {return ResponseEntity.ok(event);}
        else {return ResponseEntity.notFound().build();}

    }

    @DeleteMapping(path = "/events/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        boolean successful = eventService.deleteById(id);
        if (successful) {return ResponseEntity.ok().build();}
        else {return ResponseEntity.notFound().build();}
    }

    @GetMapping("/events/count")
    public Long count() {
        return eventService.countEvents();
    }

    private boolean validate(EventManipulationRequest request){
        return request.getEventName() != null
        && request.getEventDes() != null
        && request.getEventLocation() != null
        && request.getEventStart() != null
        && request.getEventCategory() != null
        && !request.getEventName().isBlank()
        && !request.getEventDes().isBlank()
        && !request.getEventLocation().isBlank()
        && !request.getEventCategory().isBlank();
    }
}
