package ohjelmistoprojekti1.ticketguru.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import ohjelmistoprojekti1.ticketguru.domain.Event;
import ohjelmistoprojekti1.ticketguru.domain.EventRepository;



@RestController
@RequestMapping("/api/events")
public class EventRestController {

   

    @Autowired
    private EventRepository eventRepository;


    @GetMapping
    public ResponseEntity <Iterable<Event>> getAllEvents() {
        return
        ResponseEntity.ok(eventRepository.findAll());
       
    }

    @GetMapping("/{id}")
    public Event getEventById(@PathVariable Long id) {
        return eventRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));
    }

    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Event createEvent(@Valid @RequestBody Event event) {
        return eventRepository.save(event);
    }

    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable Long id, @RequestBody Event event) {
        if (!eventRepository.existsById(id)) {
            return null;
        }
        event.setId(id);
        return eventRepository.save(event);
    }

    @PatchMapping("/{id}")
    public Event patchEvent(@PathVariable Long id, @RequestBody Event event) {
        if (!eventRepository.existsById(id)) {
            return null;
        }

        Event existingEvent = eventRepository.findById(id).get();

        if (event.getName() != null) {
            existingEvent.setName(event.getName());
        }
        if (event.getDescription() != null) {
            existingEvent.setDescription(event.getDescription());
        }
        if (event.getStartTime() != null) {
            existingEvent.setStartTime(event.getStartTime());
        }
        if (event.getEndTime() != null) {
            existingEvent.setEndTime(event.getEndTime());
        }
        if (event.getLocation() != null) {
            existingEvent.setLocation(event.getLocation());
        }
        if (event.getTicketCount() >= 0) {
            existingEvent.setTicketCount(event.getTicketCount());
        }

        return eventRepository.save(existingEvent);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventRepository.deleteById(id);
    }

}
