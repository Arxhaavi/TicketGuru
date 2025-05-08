package ohjelmistoprojekti1.ticketguru;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import ohjelmistoprojekti1.ticketguru.model.Ticket;
import ohjelmistoprojekti1.ticketguru.repository.TicketRepository;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
public class TicketRepositoryTest {

    @Autowired
    private TicketRepository ticketRepository;

    // Testataan lipun hakemista koodin perusteella
    @Test
    void shouldFindTicketByCode() {
        Optional<Ticket> found = ticketRepository.findByCode("CODE12345");
        assertTrue(found.isPresent());
        assertEquals("CODE12345", found.get().getCode());
    }

    // Luodaan uusi lippu ja tallennetaan se
    @Test
    void shouldSaveAndRetrieveTicket() {
        Ticket ticket = new Ticket();
        ticket.setCode("NEWCODE123");
        ticket.setTicketUsed(false);
        ticket.setEvent(ticketRepository.findByCode("CODE12345").get().getEvent());
        ticket.setTicketType(ticketRepository.findByCode("CODE12345").get().getTicketType());

        Ticket saved = ticketRepository.save(ticket);
        Optional<Ticket> found = ticketRepository.findById(saved.getTicketId());

        assertTrue(found.isPresent());
        assertEquals("NEWCODE123", found.get().getCode());
    }

    // Haetaan olemassa oleva lippu ja poistetaan se
    @Test
    void shouldDeleteTicket() {
        Ticket ticket = ticketRepository.findByCode("CODE12345").orElseThrow();
        ticketRepository.delete(ticket);

        Optional<Ticket> deleted = ticketRepository.findById(ticket.getTicketId());
        assertTrue(deleted.isEmpty());
    }
}