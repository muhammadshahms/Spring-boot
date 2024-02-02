package com.example.demo.controller;

import com.example.demo.dto.EventDto;
import com.example.demo.models.Event;
import com.example.demo.services.EventService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

    @GetMapping("/event")
    public String eventList(Model model) {
        List<EventDto> event = eventService.findAllEvents();
        model.addAttribute("event", event);
        return "event/event-list";
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
    public String editEventForm(@PathVariable("eventId") Long eventId, Model model) {
        EventDto event = eventService.findEventById(eventId);
        model.addAttribute("event", event);
        return "event/event-edit";
    }

    @PostMapping("/event/{eventId}/edit")
    public String updateEvent(@PathVariable("eventId") Long eventId,
                              @Valid @ModelAttribute("event") EventDto event,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("event", event);
            return "event/event-edit";
        }
        EventDto eventDto = eventService.findEventById(eventId);
        event.setId(eventId);
        event.setClub(eventDto.getClub());
        eventService.updateEvent(event);
        return "redirect:/event";
    }

    @GetMapping("/event/{eventId}/delete")
    public String deleteEvent(@PathVariable("eventId") long eventId) {
        eventService.deleteEvent(eventId);
        return "redirect:/event";
    }
}
