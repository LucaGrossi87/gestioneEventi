package com.gestioneeventi.GestioneEventi.controller;

import com.gestioneeventi.GestioneEventi.model.Event;
import com.gestioneeventi.GestioneEventi.model.User;
import com.gestioneeventi.GestioneEventi.service.EventService;
import com.gestioneeventi.GestioneEventi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;
    @Autowired
    private UserService userService;

    @GetMapping
    public List<Event> getEvents() {
        return eventService.getEvents();
    }

    @GetMapping("/{id}")
    public Event getEvent(@PathVariable Long id) {
        return eventService.getEventById(id);
    }

    @PostMapping
    public Event createEvent(@RequestBody Event event, @AuthenticationPrincipal UserDetails userDetails) {
        User organizer = (User) userService.loadUserByUsername(userDetails.getUsername());
        return eventService.createEvent(event, organizer);
    }

    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable Long id, @RequestBody Event eventDetails) {
        return eventService.updateEvent(id, eventDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
    }
}
