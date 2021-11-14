package com.example.webtech.web;


import com.example.webtech.persistance.Event;
import com.example.webtech.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EventRestController {

    @Autowired
    EventService service;

    private List<Event> events;

    public EventRestController() {
        events = new ArrayList<>();
        events.add(new Event("Essen Gehen", "Essen mit Freundin und ihrer Familie", LocalDateTime.of(2021, 12, 12, 15, 0, 0), "Umami Prenzlauerberg", "1234567890"));
        events.add(new Event("Impftermin", "Auffrischungsimpfung mit Moderna ", LocalDateTime.of(2021, 12, 15, 11, 30, 0), "Mercides Areana", "2345678901"));



    }

    @PostMapping(path =  "/events")
    public Event createEvent(@RequestBody Event event){
        return service.save(event);
    }

    @PostMapping(path =  "/events/{id}")
    public Event getEvent(@PathVariable String eventId){
        long id = Long.parseLong(eventId);
        return service.get(id);
    }


    @GetMapping(path = "/api/v1/events")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<List<Event>> fetchEvents(){
        return ResponseEntity.ok(events);
    }
}
