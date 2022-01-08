package com.example.webtech.service;

import com.example.webtech.persistance.Event;
import com.example.webtech.persistance.EventEntity;
import com.example.webtech.persistance.EventManipulationRequest;
import com.example.webtech.persistance.EventRepository;
import com.example.webtech.web.EventCreateRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.time.LocalDateTime;
import java.util.*;

public class EventServiceTest {

    @Autowired
    private EventService service;

    @Mock
    private EventRepository repository;


    //Test without Mock//
    @Test
    @DisplayName("Should return Events that took place or will take place today")
    void findalleventstoday() {

        EventEntity event1 = new EventEntity("Eating", "Eating with friends", LocalDateTime.now(), "Somewhere", "Eating");
        EventEntity event2 = new EventEntity("Dentist Appointment", "Professional Teeth cleaning", LocalDateTime.now().plusMonths(2), "Praxis Mueller", "Appointment");
        EventEntity event3 = new EventEntity("Shopping", "shopping for new clothes", LocalDateTime.now(), "Alexa", "Others");


        List<EventEntity> events = new ArrayList<>();
        events.add(event2);
        events.add(event1);
        events.add(event3);

        List<EventEntity> resultevents = new ArrayList<>();
        resultevents.add(event2);
        resultevents.add(event1);
        resultevents.add(event3);

        LocalDateTime currentDate = LocalDateTime.now();
        ListIterator<EventEntity> eventstoday = events.listIterator();
        do {

            EventEntity event = eventstoday.next();
            System.out.println(event.getEventName() + " " + event.getEventStart());
            if (
                    (event.getEventStart().getDayOfMonth() == currentDate.getDayOfMonth())
                            && (event.getEventStart().getMonth() == currentDate.getMonth())
                            && (event.getEventStart().getYear() == currentDate.getYear())) {
                System.out.println(event.getEventName() + " today");
            } else {
                resultevents.remove(event);
                System.out.println(event.getEventName() + " not today");

            }
        }
        while (eventstoday.hasNext());

        var expected = 2;
        var actual = resultevents.size();
        assertEquals(expected, actual);

    }
    @Test
    @DisplayName("should return all events")
    void getFindAll() {
        Event event1 = new Event(1L,"Eating", "Eating with friends", LocalDateTime.now(), "Somewhere", "Eating");
        Event event2 = new Event(2L,"Dentist Appointment", "Professional Teeth cleaning", LocalDateTime.now().plusMonths(2), "Praxis Mueller", "Appointment");
        Event event3 = new Event(3L,"Shopping", "shopping for new clothes", LocalDateTime.now(), "Alexa", "Others");

        doReturn(List.of(event1,event2,event3)).when(repository).findAll();
        var actual = service.findAll();
        var expected= List.of(event1,event2,event3);
        Assertions.assertSame(expected, actual);

    }

    @Test
    @DisplayName("should return all events")
    void getFindAll2() {

        EventManipulationRequest eventm1 = new EventManipulationRequest("Eating", "Eating with friends", LocalDateTime.now(), "Somewhere", "Eating");
        EventManipulationRequest eventm2 = new EventManipulationRequest("Dentist Appointment", "Professional Teeth cleaning", LocalDateTime.now().plusMonths(2), "Praxis Mueller", "Appointment");
        EventManipulationRequest eventm3 = new EventManipulationRequest("Shopping", "shopping for new clothes", LocalDateTime.now(), "Alexa", "Others");

        service.create(eventm1);
        service.create(eventm2);
        service.create(eventm3);

        var actual = service.findAll();

        var expected= List.of(eventm1,eventm2,eventm3);
        Assertions.assertSame(expected, actual);

    }
    @Test
    @DisplayName("should return false if person to delete does not exist")
    void should_return_false_if_person_to_delete_does_not_exist() {

        var todeleteId = 15L;
        doReturn(false).when(repository).existsById(todeleteId);

        boolean actual = service.deleteById(todeleteId);

        verifyNoMoreInteractions(repository);
        Assertions.assertSame(false, actual);
    }
}

