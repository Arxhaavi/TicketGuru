package ohjelmistoprojekti1.ticketguru.web;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import ohjelmistoprojekti1.ticketguru.domain.Event;
import ohjelmistoprojekti1.ticketguru.domain.EventRepository;
import ohjelmistoprojekti1.ticketguru.domain.TicketRepository;

@RestController
@RequestMapping("/api/events")
public class EventRestController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private Validator validator;

    @GetMapping
    public ResponseEntity<Iterable<Event>> getAllEvents() {
        return ResponseEntity.ok(eventRepository.findAll());

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
    public Event updateEvent(@PathVariable Long id, @Valid @RequestBody Event event) {
        if (!eventRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
        }
        event.setId(id);
        return eventRepository.save(event);
    }

   @PatchMapping("/{id}")
public Event patchEvent(@PathVariable Long id, @Valid @RequestBody Event event, BindingResult bindingResult) {
    if (!eventRepository.existsById(id)) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
    }

    Event existingEvent = eventRepository.findById(id).get();

    validatePatchFields(event);

    if (event.getName() != null) {
        existingEvent.setName(event.getName());
    }
    if (event.getDescription() != null) {
        existingEvent.setDescription(event.getDescription());
    }
    if (event.getStartTime() != null && !event.getStartTime().toString().trim().isEmpty()) {
        existingEvent.setStartTime(event.getStartTime());
    }
    
    if (event.getEndTime() != null && !event.getEndTime().toString().trim().isEmpty()) {
        existingEvent.setEndTime(event.getEndTime());
    }
    if (event.getLocation() != null) {
        existingEvent.setLocation(event.getLocation());
    }
    if (event.getTicketCount() != null) {
        if (event.getTicketCount() < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ticket count cannot be negative");
        }
        existingEvent.setTicketCount(event.getTicketCount());
    }

    return eventRepository.save(existingEvent);
}

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        Optional<Event> event = eventRepository.findById(id);

        if (ticketRepository.existsByEventId(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Can't delete an event that has tickets");
        }

        if (event.isPresent()) {
            eventRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
        }
    }

        private void validatePatchFields(Event event) {
            Set<ConstraintViolation<Event>> violations = validator.validate(event);
    
            for (ConstraintViolation<Event> violation : violations) {
                if (violation.getInvalidValue() != null) { 
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, violation.getMessage());
                }
            }
        }
    
}