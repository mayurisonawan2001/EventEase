package com.youreventease.service;

import com.youreventease.model.Event;
import com.youreventease.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event addEvent(Event event) {
        event.setTicketsAvailable(event.getTotalTickets());
        return eventRepository.save(event);
    }
}
