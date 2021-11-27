package com.example.webtech.persistance;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collector;


public class Event {



    private Long id;


    private String eventName;

    private String eventDes;

    private LocalDateTime eventStart;

    private String eventLocation;

    private String eventCoordinate;



    public Event(Long id,String eventName, String eventDes, LocalDateTime eventStart, String eventLocation, String eventCoordinate) {
        this.id =id;
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
