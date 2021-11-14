package com.example.webtech.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    @Autowired
    EventRepository eventRepository;

    public Event save(Event event){
        return eventRepository.save(event);
    }

    public Event get(Long id){
        return eventRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }

}
