package ohjelmistoprojekti1.ticketguru;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ohjelmistoprojekti1.ticketguru.model.Event;
import ohjelmistoprojekti1.ticketguru.model.Location;
import ohjelmistoprojekti1.ticketguru.model.Postalcode;

//Luokka event-entityn yksikkötesteille
public class EventTests {

    private static Validator validator;

    @BeforeAll
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    // Metodi jolla luodaan validi tapahtuma
    private Event createValidEvent() {
        Event event = new Event();
        event.setName("Valid Event");
        event.setDescription("This is a valid event description.");
        event.setStartTime(LocalDateTime.now().plusDays(1));
        event.setEndTime(LocalDateTime.now().plusDays(2));

        Postalcode postalcode = new Postalcode();
        postalcode.setPostalcode("12345");
        postalcode.setCity("Helsinki");
        postalcode.setCountry("Suomi");

        Location location = new Location();
        location.setName("Paikka");
        location.setStreetAddress("Paikkakuja 1");
        location.setPostalcode(postalcode);
        location.setCapacity(1500);
        event.setLocation(location);

        event.setTicketCount(100);
        return event;
    }

    // Testi jolla testataan validia tapahtuman nimeä
    @Test
    public void testValidEventName() {
        Event event = createValidEvent();
        event.setName("Valid Name");

        Set<ConstraintViolation<Event>> violations = validator.validate(event);
        assertTrue(violations.isEmpty(), "Validation should pass for a valid name");
    }

    // Testi jolla testataan ettei tapahtuma hyväksy tyhjää nimeä
    @Test
    public void testInvalidEventNameEmpty() {
        Event event = createValidEvent();
        event.setName("");

        Set<ConstraintViolation<Event>> violations = validator.validate(event);
        assertFalse(violations.isEmpty());
        assertTrue(violations.stream()
                .anyMatch(v -> v.getPropertyPath().toString().equals("name") &&
                        v.getMessage().contains("between 2 and 50 characters")),
                "Validation should fail for empty event name");
    }

    // Testi jolla testataan ettei tapahtuma hyväksy liian lyhyttä nimeä
    @Test
    public void testInvalidEventNameTooShort() {
        Event event = createValidEvent();
        event.setName("A");

        Set<ConstraintViolation<Event>> violations = validator.validate(event);
        assertFalse(violations.isEmpty());
        assertTrue(violations.stream()
                .anyMatch(v -> v.getPropertyPath().toString().equals("name") &&
                        v.getMessage().contains("between 2 and 50 characters")),
                "Validation should fail for event name too short");
    }

    // Testi liian pitkälle tapahtuman nimelle
    @Test
    public void testInvalidEventNameTooLong() {
        Event event = createValidEvent();
        event.setName("A".repeat(51));

        Set<ConstraintViolation<Event>> violations = validator.validate(event);
        assertFalse(violations.isEmpty());
        assertTrue(violations.stream()
                .anyMatch(v -> v.getPropertyPath().toString().equals("name") &&
                        v.getMessage().contains("between 2 and 50 characters")),
                "Validation should fail for event name too long");
    }

    // Testi validille aloitusajalle
    @Test
    public void testValidEventStartTime() {
        Event event = createValidEvent();
        event.setStartTime(LocalDateTime.now().plusDays(1));

        Set<ConstraintViolation<Event>> violations = validator.validate(event);
        assertTrue(violations.isEmpty(), "Validation should pass for a valid start time");
    }

    // Testi jolla testataan ettei tapahtuma hyväksy aloitusaikaa menneisyydestä
    @Test
    public void testInvalidEventStartTimePast() {
        Event event = createValidEvent();
        event.setStartTime(LocalDateTime.now().minusDays(1));

        Set<ConstraintViolation<Event>> violations = validator.validate(event);
        assertFalse(violations.isEmpty());
        assertTrue(violations.stream()
                .anyMatch(v -> v.getPropertyPath().toString().equals("startTime") &&
                        v.getMessage().contains("must be in the future or present")),
                "Validation should fail for start time in the past");
    }

    // Testi joka testaa että tapahtuma hyväksyy validin lopetusajan
    @Test
    public void testValidEventEndTime() {
        Event event = createValidEvent();
        event.setStartTime(LocalDateTime.now().plusDays(1));
        event.setEndTime(LocalDateTime.now().plusDays(2));

        Set<ConstraintViolation<Event>> violations = validator.validate(event);
        assertTrue(violations.isEmpty(), "Validation should pass for valid end time");
    }

    // Testi ettei tapahtuma hyväksy lopetusaikaa ennen aloitusaikaa
    @Test
    public void testInvalidEventEndTimeBeforeStartTime() {
        Event event = createValidEvent();
        event.setStartTime(LocalDateTime.now().plusDays(2));
        event.setEndTime(LocalDateTime.now().plusDays(1));

        Set<ConstraintViolation<Event>> violations = validator.validate(event);
        assertFalse(violations.isEmpty());
        assertTrue(violations.stream()
                .anyMatch(v -> v.getPropertyPath().toString().equals("endTimeAfterStartTime") &&
                        v.getMessage().contains("End time must be after start time")),
                "Validation should fail for end time before start time");
    }

    // Testi että tapahtuma hyväksyy validin määrän lippuja
    @Test
    public void testValidTicketCount() {
        Event event = createValidEvent();
        event.setTicketCount(100);

        Set<ConstraintViolation<Event>> violations = validator.validate(event);
        assertTrue(violations.isEmpty(), "Validation should pass for valid ticket count");
    }

    // Testi ettei tapahtuma hyväksy negatiivista lippujen määrää
    @Test
    public void testInvalidTicketCountNegative() {
        Event event = createValidEvent();
        event.setTicketCount(-1);

        Set<ConstraintViolation<Event>> violations = validator.validate(event);
        assertFalse(violations.isEmpty());
        assertTrue(violations.stream()
                .anyMatch(v -> v.getPropertyPath().toString().equals("ticketCount") &&
                        v.getMessage().contains("must be at least 1")),
                "Validation should fail for negative ticket count");
    }

    // Testi ettei tapahtuma hyväksy nollaa lippua lippumääräksi
    @Test
    public void testInvalidTicketCountZero() {
        Event event = createValidEvent();
        event.setTicketCount(0);

        Set<ConstraintViolation<Event>> violations = validator.validate(event);
        assertFalse(violations.isEmpty());
        assertTrue(violations.stream()
                .anyMatch(v -> v.getPropertyPath().toString().equals("ticketCount") &&
                        v.getMessage().contains("must be at least 1")),
                "Validation should fail for zero ticket count");
    }

    // Testi ettei tapahtuma hyväksy tyhjää lokaatiota
    @Test
    public void testInvalidLocationNull() {
        Event event = createValidEvent();
        event.setLocation(null);

        Set<ConstraintViolation<Event>> violations = validator.validate(event);
        assertFalse(violations.isEmpty());
        assertTrue(violations.stream()
                .anyMatch(v -> v.getPropertyPath().toString().equals("location") &&
                        v.getMessage().contains("Location is mandatory")),
                "Validation should fail for null location");
    }
}
