package com.example.demo.Mapper;

import com.example.demo.dto.EventDto;
import com.example.demo.models.Event;

public class EventMapper {
    public static Event mapToEvent(EventDto eventDto) {
        return Event.builder()
                .name(eventDto.getName())
                .location(eventDto.getLocation())
                .photoUrl(eventDto.getPhotoUrl())
                .type(eventDto.getType())
                .details(eventDto.getDetails())
                .startTime(eventDto.getStartTime())
                .endTime(eventDto.getEndTime())
                .type(eventDto.getType())
                .club(eventDto.getClub())
                .createdOn(eventDto.getCreatedOn())
                .updateOn(eventDto.getUpdateOn())
                .build();
    }

    public static EventDto mapToEventDto(Event event) {
        return EventDto.builder()
                .id(event.getId())
                .name(event.getName())
                .location(event.getLocation())
                .photoUrl(event.getPhotoUrl())
                .details(event.getDetails())
                .type(event.getType())
                .startTime(event.getStartTime())
                .endTime(event.getEndTime())
                .club(event.getClub())
                .createdOn(event.getCreatedOn())
                .updateOn(event.getUpdateOn())
                .build();
    }
}
