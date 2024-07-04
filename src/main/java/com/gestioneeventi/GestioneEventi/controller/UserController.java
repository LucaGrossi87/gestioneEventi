package com.gestioneeventi.GestioneEventi.controller;

import com.gestioneeventi.GestioneEventi.model.Event;
import com.gestioneeventi.GestioneEventi.model.User;
import com.gestioneeventi.GestioneEventi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/events")
    public List<Event> getBookedEvents(@AuthenticationPrincipal UserDetails userDetails) {
        User user = (User) userService.loadUserByUsername(userDetails.getUsername());
        return userService.getBookedEvents(user);
    }

    @DeleteMapping("/events/{eventId}/cancel")
    public void cancelBooking(@PathVariable Long eventId, @AuthenticationPrincipal UserDetails userDetails) {
        User user = (User) userService.loadUserByUsername(userDetails.getUsername());
        userService.cancelBooking(eventId, user);
    }
}
