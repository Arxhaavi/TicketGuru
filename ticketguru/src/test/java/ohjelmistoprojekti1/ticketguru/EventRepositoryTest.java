package ohjelmistoprojekti1.ticketguru;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;

import ohjelmistoprojekti1.ticketguru.model.Event;
import ohjelmistoprojekti1.ticketguru.repository.EventRepository;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
@ComponentScan(basePackages = "ohjelmistoprojekti1.ticketguru")
public class EventRepositoryTest {

    @Autowired
    private EventRepository eventRepository;

    // Integraatiotesti jossa testataan tapahtuman luomista ja tallentamista
    @Test
    void shouldSaveAndRetrieveEvent() {
        Event event = new Event();
        event.setName("Tapahtuma5000");
        event.setDescription("Tapahtuma numero 5000");
        event.setTicketCount(2500);

        Event saved = eventRepository.save(event);
        Optional<Event> found = eventRepository.findById(saved.getEvent_Id());

        assertTrue(found.isPresent());
        assertEquals("Tapahtuma5000", found.get().getName());
    }

    // Integraatiotesti jossa testataan tapahtuman poistamista
    @Test
    void shouldDeleteEvent() {
        Event event = new Event();
        event.setName("IsoTapahtuma");
        event = eventRepository.save(event);

        eventRepository.delete(event);
        Optional<Event> deleted = eventRepository.findById(event.getEvent_Id());

        assertTrue(deleted.isEmpty());
    }
}