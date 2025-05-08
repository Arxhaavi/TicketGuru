package ohjelmistoprojekti1.ticketguru;

import static org.junit.jupiter.api.Assertions.*;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ohjelmistoprojekti1.ticketguru.model.SalesTransaction;

import java.time.LocalDateTime;
import java.util.Set;

public class SalesTransactionTests {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    // Testataan validin myyntitapahtuman luomista
    @Test
    public void testValidSalesTransaction() {
        SalesTransaction transaction = new SalesTransaction();
        transaction.setTransactionTime(LocalDateTime.now());
        transaction.setSum(100.0);

        Set<ConstraintViolation<SalesTransaction>> violations = validator.validate(transaction);
        assertTrue(violations.isEmpty());
    }

    // Testataan myyntitapahtuman luomista ilman aikaa
    @Test
    public void testInvalidNullTransactionTime() {
        SalesTransaction transaction = new SalesTransaction();
        transaction.setTransactionTime(null);
        transaction.setSum(100.0);

        Set<ConstraintViolation<SalesTransaction>> violations = validator.validate(transaction);
        assertFalse(violations.isEmpty());
        assertEquals("Transaction time is mandatory", violations.iterator().next().getMessage());
    }

    // Testataan myyntitapahtuman luomista negatiivisella summalla
    @Test
    public void testInvalidNegativeSum() {
        SalesTransaction transaction = new SalesTransaction();
        transaction.setTransactionTime(LocalDateTime.now());
        transaction.setSum(-50.0);

        Set<ConstraintViolation<SalesTransaction>> violations = validator.validate(transaction);
        assertFalse(violations.isEmpty());
        assertEquals("Sum must be at least 0", violations.iterator().next().getMessage());
    }
}