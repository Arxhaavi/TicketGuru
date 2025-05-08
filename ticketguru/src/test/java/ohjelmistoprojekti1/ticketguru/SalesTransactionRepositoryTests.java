package ohjelmistoprojekti1.ticketguru;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import ohjelmistoprojekti1.ticketguru.model.SalesTransaction;
import ohjelmistoprojekti1.ticketguru.repository.SalesTransactionRepository;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
public class SalesTransactionRepositoryTests {

    @Autowired
    private SalesTransactionRepository salesTransactionRepository;

    // Testataan myyntitapahtuman tallentamista ja hakemista
    @Test
    void shouldSaveAndRetrieveSalesTransaction() {
        SalesTransaction transaction = new SalesTransaction();
        transaction.setTransactionTime(LocalDateTime.now());
        transaction.setSum(150.0);

        SalesTransaction saved = salesTransactionRepository.save(transaction);
        Optional<SalesTransaction> found = salesTransactionRepository.findById(saved.getTransactionId());

        assertTrue(found.isPresent());
        assertEquals(150.0, found.get().getSum());
    }

    // Testataan myyntitapahtuman poistamista
    @Test
    void shouldDeleteSalesTransaction() {
        SalesTransaction transaction = new SalesTransaction();
        transaction.setTransactionTime(LocalDateTime.now());
        transaction.setSum(200.0);

        transaction = salesTransactionRepository.save(transaction);
        salesTransactionRepository.delete(transaction);

        Optional<SalesTransaction> deleted = salesTransactionRepository.findById(transaction.getTransactionId());
        assertTrue(deleted.isEmpty());
    }
}