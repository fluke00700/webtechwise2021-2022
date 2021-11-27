package com.example.webtech.persistance;

import javax.persistence.*;
import java.time.LocalDateTime;




    @Entity(name = "events")
    public class EventEntity {

        public EventEntity(String eventName, String eventDes, LocalDateTime eventStart, String eventLocation, String eventCoordinate) {
            this.eventName = eventName;
            this.eventDes = eventDes;
            this.eventStart = eventStart;
            this.eventLocation = eventLocation;
            this.eventCoordinate = eventCoordinate;
        }

        protected EventEntity() {}


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "event_name", nullable = false)
        private String eventName;
        @Column(name = "event_description", nullable = false)
        private String eventDes;
        @Column(name = "event_start", nullable = false)
        private LocalDateTime eventStart;
        @Column(name = "event_location", nullable = false)
        private String eventLocation;
        @Column(name = "event_coordinate", nullable = false)
        private String eventCoordinate;



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


