package com.gestioneeventi.GestioneEventi.repository;

import com.gestioneeventi.GestioneEventi.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByOrganizerId(Long organizerId);
}