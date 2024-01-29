package com.example.demo.services.impl;

import com.example.demo.dto.EventDto;
import com.example.demo.models.Club;
import com.example.demo.models.Event;
import com.example.demo.repository.ClubRepository;
import com.example.demo.repository.EventRepository;
import com.example.demo.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void createEvent(Long clubId, EventDto event) {
        Club club = clubRepository.findById(clubId).get();
        Event event1 = mapToEvent(event);
        eventRepository.save(event1);
    }

    private Event mapToEvent(EventDto eventDto) {
        return Event.builder()
                .name(eventDto.getName())
                .location(eventDto.getLocation())
//                .photoUrl(eventDto.getPhotoUrl())
                .type(eventDto.getType())
                .startTime(eventDto.getStartTime())
                .endTime(eventDto.getEndTime())
                .type(eventDto.getType())
                .createdOn(eventDto.getCreatedOn())
                .updateOn(eventDto.getUpdateOn())
                .build();
    }
}
