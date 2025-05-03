package ohjelmistoprojekti1.ticketguru;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import ohjelmistoprojekti1.ticketguru.model.Event;

public class EventTests {

    @Test
    public void testSetAndGetName() {
        Event event = new Event();
        event.setName("Tapahtuma");
        assertEquals("Tapahtuma", event.getName());
    }

    @Test
    public void testSetNoName() {
        Event event = new Event();
        event.setName("");
        assertEquals("", event.getName());
    }

    @Test
    public void testSetAndGetTicketCount() {
        Event event = new Event();
        event.setTicketCount(1500);
        assertEquals(1500, event.getTicketCount());
    }

    @Test
    public void testSetNegativeTicketCount() {
        Event event = new Event();
        event.setTicketCount(-500);
        assertEquals(-500, event.getTicketCount());
    }

    @Test
    public void testSetZeroTicketCount() {
        Event event = new Event();
        event.setTicketCount(0);
        assertEquals(0, event.getTicketCount());
    }
}
