package com.gestioneeventi.GestioneEventi.controller;

import com.gestioneeventi.GestioneEventi.model.User;
import com.gestioneeventi.GestioneEventi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user, @RequestParam String role) {
        return userService.registerUser(user, role);
    }
}
