package com.example.demo.controller;

import com.example.demo.dto.EventDto;
import com.example.demo.models.Event;
import com.example.demo.services.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EventController {
    private EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/event/{clubId}/new")
    public String createEventForm(@PathVariable Long clubId, Model model) {
        Event event = new Event();
        model.addAttribute("clubId", clubId);
        model.addAttribute("event", event);
        return "event/event-create";
    }

    @PostMapping("/event/{clubId}")
    public String createEvent(@PathVariable Long clubId, @ModelAttribute("event") EventDto eventDto, Model model) {
        eventService.createEvent(clubId, eventDto);
        return "redirect:/club/" + clubId;
    }

    @GetMapping("/event/{eventId}")
    public String viewEvent(@PathVariable Long eventId, Model model) {
        Event event = eventService.viewEvent(eventId);
        model.addAttribute("event", event);
        return "event/event-view";
    }

    @GetMapping("/event/{eventId}/edit")
    public String editEventForm(@PathVariable Long eventId, Model model) {
        Event event = eventService.findEventById(eventId);
        model.addAttribute("event", event);
        return "event/event-edit";
    }

    @PostMapping("/event/{eventId}/edit")
    public String updateEvent(@PathVariable Long eventId, @ModelAttribute("event") EventDto event, Model model) {
        Event eventToUpdate = eventService.findEventById(eventId);
        eventService.updateEvent(event);
        event.setId(eventId);

        return "redirect:/event/" + eventId;
    }

    @GetMapping("/event/{eventId}/delete")
    public String deleteEvent(@PathVariable Long eventId) {
        eventService.deleteEvent(eventId);
        return "redirect:/event/" + eventId;
    }
}
