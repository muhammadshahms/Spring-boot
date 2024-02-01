package com.example.demo.services;

import com.example.demo.dto.EventDto;
import com.example.demo.models.Event;

public interface EventService {
    void createEvent(Long clubId, EventDto eventDto);

    Event viewEvent(Long eventId);

    void updateEvent(Long eventId);

    Event findEventById(Long eventId);

    //findEventById


/*
    EventDto saveEvent(EventDto event);

    EventDto findEventById(Long eventId);

    void updateEvent(EventDto event);

    void deleteEvent(Long eventId);

    List<EventDto> findByQuery(String query);
*/
}
