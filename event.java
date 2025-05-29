package com.youreventease.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String location;
    private LocalDateTime dateTime;
    private int totalTickets;
    private int ticketsAvailable;

    // Getters and setters
}
