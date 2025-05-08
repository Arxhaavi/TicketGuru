package ohjelmistoprojekti1.ticketguru;

import static org.junit.jupiter.api.Assertions.*;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ohjelmistoprojekti1.ticketguru.model.Event;
import ohjelmistoprojekti1.ticketguru.model.Ticket;
import ohjelmistoprojekti1.ticketguru.model.TicketType;

import java.util.Set;

public class TicketTests {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    // Testataan validin lipun luomista
    @Test
    public void testValidTicket() {
        Ticket ticket = new Ticket();
        ticket.setTicketType(new TicketType("Opiskelija"));
        ticket.setEvent(new Event());
        ticket.setCode("VALIDCODE123");
        ticket.setTicketUsed(false);

        Set<ConstraintViolation<Ticket>> violations = validator.validate(ticket);
        assertTrue(violations.isEmpty());
    }

    // Testataan lipun luomista ilman koodia
    @Test
    public void testInvalidNullCode() {
        Ticket ticket = new Ticket();
        ticket.setTicketType(new TicketType("Opiskelija"));
        ticket.setEvent(new Event());
        ticket.setCode(null);
        ticket.setTicketUsed(false);

        Set<ConstraintViolation<Ticket>> violations = validator.validate(ticket);
        assertFalse(violations.isEmpty());
        assertEquals("Ticket code cannot be null", violations.iterator().next().getMessage());
    }

    // Testataan lipun luomista ilman lipputyyppiä
    @Test
    public void testInvalidNullTicketType() {
        Ticket ticket = new Ticket();
        ticket.setTicketType(null);
        ticket.setEvent(new Event());
        ticket.setCode("VALIDCODE123");
        ticket.setTicketUsed(false);

        Set<ConstraintViolation<Ticket>> violations = validator.validate(ticket);
        assertFalse(violations.isEmpty());
        assertEquals("Ticket type cannot be null", violations.iterator().next().getMessage());
    }

    // Testataan lipun luomista ilman tapahtumaa
    @Test
    public void testInvalidNullEvent() {
        Ticket ticket = new Ticket();
        ticket.setTicketType(new TicketType("Opiskelija"));
        ticket.setEvent(null);
        ticket.setCode("VALIDCODE123");
        ticket.setTicketUsed(false);

        Set<ConstraintViolation<Ticket>> violations = validator.validate(ticket);
        assertFalse(violations.isEmpty());
        assertEquals("Event cannot be null", violations.iterator().next().getMessage());
    }
}