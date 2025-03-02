package ohjelmistoprojekti1.ticketguru.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ohjelmistoprojekti1.ticketguru.domain.Event;
import ohjelmistoprojekti1.ticketguru.domain.EventRepository;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/events")
public class EventRestController {

    @Autowired
    private EventRepository eventRepository;

    @GetMapping()
    public Iterable<Event> getAllEvents() {
        return eventRepository.findAll();
    }
}
