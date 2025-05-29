package com.youreventease.service;

import com.youreventease.model.Booking;
import com.youreventease.model.Event;
import com.youreventease.model.User;
import com.youreventease.repository.BookingRepository;
import com.youreventease.repository.EventRepository;
import com.youreventease.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    private String generateBookingCode() {
        return UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    @Transactional
    public Booking bookTicket(Long userId, Long eventId) throws Exception {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new Exception("User not found"));

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new Exception("Event not found"));

        if (event.getTicketsAvailable() <= 0) {
            throw new Exception("No tickets available");
        }

        event.setTicketsAvailable(event.getTicketsAvailable() - 1);
        eventRepository.save(event);

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setEvent(event);
        booking.setBookingTime(LocalDateTime.now());
        booking.setBookingCode(generateBookingCode());

        return bookingRepository.save(booking);
    }

    public boolean validateBookingCode(String code) {
        Optional<Booking> booking = bookingRepository.findByBookingCode(code);
        return booking.isPresent();
    }
}
