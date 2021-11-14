package com.example.webtech.web.api;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Event {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String eventName;
    private String eventDes;
    private LocalDateTime eventStart;
    private String eventLocation;
    private String eventCoordinate;

    public Event(String eventName, String eventDes, LocalDateTime eventStart, String eventLocation, String eventCoordinate) {
        this.eventName = eventName;
        this.eventDes = eventDes;
        this.eventStart = eventStart;
        this.eventLocation = eventLocation;
        this.eventCoordinate = eventCoordinate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDes() {
        return eventDes;
    }

    public void setEventDes(String eventDes) {
        this.eventDes = eventDes;
    }

    public LocalDateTime getEventStart() {
        return eventStart;
    }

    public void setEventStart(LocalDateTime eventStart) {
        this.eventStart = eventStart;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventCoordinate() {
        return eventCoordinate;
    }

    public void setEventCoordinate(String eventCoordinate) {
        this.eventCoordinate = eventCoordinate;
    }
}
