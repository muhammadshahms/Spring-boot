package com.example.demo.services;

import com.example.demo.dto.EventDto;
public interface EventService {
    void createEvent(Long clubId, EventDto eventDto);

/*
    EventDto saveEvent(EventDto event);

    EventDto findEventById(Long eventId);

    void updateEvent(EventDto event);

    void deleteEvent(Long eventId);

    List<EventDto> findByQuery(String query);
*/
}
