package com.example.demo.services;

import com.example.demo.dto.EventDto;
import com.example.demo.models.Event;

import java.util.List;

public interface EventService {
    void createEvent(Long clubId, EventDto eventDto);

    Event viewEvent(Long eventId);

    EventDto findEventById(Long eventId);

    void updateEvent(EventDto eventDto);

    void deleteEvent(Long eventId);

    List<EventDto> findAllEvents();

    //findEventById


/*
    EventDto saveEvent(EventDto event);

    EventDto findEventById(Long eventId);

    void updateEvent(EventDto event);

    void deleteEvent(Long eventId);

    List<EventDto> findByQuery(String query);
*/
}
