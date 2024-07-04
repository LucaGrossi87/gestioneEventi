package com.gestioneeventi.GestioneEventi.model;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime date;
    private String location;
    private int availableSeats;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private User organizer;
}