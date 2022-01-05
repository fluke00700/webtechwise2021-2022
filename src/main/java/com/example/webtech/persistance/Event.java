package com.example.webtech.persistance;

import java.time.LocalDateTime;


public class Event {



    private Long id;


    private String eventName;

    private String eventDes;

    private LocalDateTime eventStart;

    private String eventLocation;

    private String eventCategory;



    public Event(Long id,String eventName, String eventDes, LocalDateTime eventStart, String eventLocation, String eventCategory) {
        this.id =id;
        this.eventName = eventName;
        this.eventDes = eventDes;
        this.eventStart = eventStart;
        this.eventLocation = eventLocation;
        this.eventCategory = eventCategory;
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

    public String getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(String eventCategory) {
        this.eventCategory = eventCategory;
    }


}
