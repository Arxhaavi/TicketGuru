package ohjelmistoprojekti1.ticketguru;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ohjelmistoprojekti1.ticketguru.domain.Ticket;

public class TicketTests {


    @Test
    public void testSetAndGetCode() {
        Ticket ticket = new Ticket();
        ticket.setCode("TESTCODE123");
        assertEquals("TESTCODE123", ticket.getCode());
    }

    @Test
    public void testSetAndGetPrice() {
        Ticket ticket = new Ticket();
        ticket.setPrice(50.0);
        assertEquals(50.0, ticket.getPrice());
    }

    @Test
    public void testSetNegativePrice() {
        Ticket ticket = new Ticket();
        ticket.setPrice(-10.0);
        assertEquals(-10.0, ticket.getPrice());
    }

}
