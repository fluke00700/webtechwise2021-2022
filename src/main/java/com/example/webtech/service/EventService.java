package com.example.webtech.service;

import com.example.webtech.persistance.Event;
import com.example.webtech.persistance.EventEntity;
import com.example.webtech.persistance.EventManipulationRequest;
import com.example.webtech.persistance.EventRepository;
import com.example.webtech.web.EventCreateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    private final EventRepository eventRepository;

    private Event transformEntity(EventEntity eventEntity) {
        return new Event(
                eventEntity.getId(),
                eventEntity.getEventName(),
                eventEntity.getEventDes(),
                eventEntity.getEventStart(),
                eventEntity.getEventLocation(),
                eventEntity.getEventCategory());
    }

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    public Event create(EventCreateRequest request){
        EventEntity eventEntity = new EventEntity(request.getEventName(), request.getEventDes(),request.getEventStart(), request.getEventLocation(), request.getEventCategory());
        eventRepository.save(eventEntity);
        return transformEntity(eventEntity);
    }

    public List<Event> findAll() {
        List<EventEntity> events = (List<EventEntity>) eventRepository.findAll();
        return events.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());

    }

    public Event findById(Long id) {
        var eventEntity = eventRepository.findById(id);
        return eventEntity.map(this::transformEntity).orElse(null);
    }


    public Event create(EventManipulationRequest request) {
        EventEntity eventEntity = new EventEntity(request.getEventName()
                                    , request.getEventDes()
                                    , request.getEventStart()
                                    , request.getEventLocation()
                                    , request.getEventCategory());
        eventEntity =eventRepository.save(eventEntity);
        return transformEntity(eventEntity);
    }

    public Event update(Long id, EventManipulationRequest request) {
        var eventEntityOptional = eventRepository.findById(id);
        if (eventEntityOptional.isEmpty()) {
            return null;
        }

        EventEntity eventEntity = eventEntityOptional.get();
        eventEntity.setEventName(request.getEventName());
        eventEntity.setEventDes(request.getEventDes());
        eventEntity.setEventStart(request.getEventStart());
        eventEntity.setEventLocation(request.getEventLocation());
        eventEntity.setEventCategory(request.getEventCategory());
        eventEntity = eventRepository.save(eventEntity);
        return transformEntity(eventEntity);
    }

    public boolean deleteById(Long id) {
        if (eventRepository.existsById(id)) {
            eventRepository.deleteById(id);
        }
        return eventRepository.existsById(id);
    }

    public Long countEvents(){
        return eventRepository.count();
    }


    }














