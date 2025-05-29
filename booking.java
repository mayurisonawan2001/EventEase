package com.youreventease.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookingCode;

    @ManyToOne
    private User user;

    @ManyToOne
    private Event event;

    private LocalDateTime bookingTime;

    // Getters and setters
}
