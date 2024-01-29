package com.example.demo.controller;

import com.example.demo.dto.EventDto;
import com.example.demo.models.Event;
import com.example.demo.services.EventService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class EventController {
    private EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/event/{clubId}/new")
    public String createEventForm(@PathVariable Long clubId, Model model) {
        Event event = new Event();
        model.addAttribute("clubId", clubId);
        model.addAttribute("events", event);
        return "event-create";
    }
}
