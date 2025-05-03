package ohjelmistoprojekti1.ticketguru;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;

import ohjelmistoprojekti1.ticketguru.model.Ticket;
import ohjelmistoprojekti1.ticketguru.repository.TicketRepository;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
@ComponentScan(basePackages = "ohjelmistoprojekti1.ticketguru")
public class TicketRepositoryTest {

    @Autowired
    private TicketRepository ticketRepository;

    @Test
    void shouldSaveAndRetrieveTicket() {
        Ticket ticket = new Ticket();
        // ticket.setPrice(42.0);
        ticket.setTicketUsed(false);

        Ticket saved = ticketRepository.save(ticket);
        Optional<Ticket> found = ticketRepository.findById(saved.getTicketId());

        assertTrue(found.isPresent());
        // assertEquals(42.0, found.get().getPrice());
    }

    @Test
    void shouldDeleteTicket() {
        Ticket ticket = new Ticket();
        ticket.setTicketUsed(false);
        ticket = ticketRepository.save(ticket);

        ticketRepository.delete(ticket);
        Optional<Ticket> deleted = ticketRepository.findById(ticket.getTicketId());

        assertTrue(deleted.isEmpty());
    }

}
