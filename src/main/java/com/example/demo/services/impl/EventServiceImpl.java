package com.example.demo.services.impl;

import com.example.demo.dto.EventDto;
import com.example.demo.models.Club;
import com.example.demo.models.Event;
import com.example.demo.repository.ClubRepository;
import com.example.demo.repository.EventRepository;
import com.example.demo.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.demo.Mapper.EventMapper.mapToEvent;
import static com.example.demo.Mapper.EventMapper.mapToEventDto;

@Service
public class EventServiceImpl implements EventService {
    private ClubRepository clubRepository;
    private EventRepository eventRepository;

    @Autowired
    public EventServiceImpl(ClubRepository clubRepository, EventRepository eventRepository) {
        this.clubRepository = clubRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public Event findEventById(Long eventId) {
        Event event = eventRepository.findById(eventId).get();
        return event;
    }
    @Override
    public void createEvent(Long clubId, EventDto eventDto) {
        Club club = clubRepository.findById(clubId).get();
        Event event = mapToEvent(eventDto);
        event.setClub(club);
        eventRepository.save(event);
    }

    @Override
    public Event viewEvent(Long eventId) {
        Event event = eventRepository.findById(eventId).get();
        EventDto eventDto = mapToEventDto(event);
        return event;
    }

    @Override
    public void updateEvent(EventDto eventDto) {
        Event event = mapToEvent(eventDto);
        eventRepository.save(event);
    }

    @Override
    public void deleteEvent(Long eventId) {
        eventRepository.deleteById(eventId);
    }
}
