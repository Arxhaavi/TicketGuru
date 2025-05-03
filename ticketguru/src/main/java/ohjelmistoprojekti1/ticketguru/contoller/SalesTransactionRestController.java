package ohjelmistoprojekti1.ticketguru.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ohjelmistoprojekti1.ticketguru.dto.SalesTransactionRequestDTO;
import ohjelmistoprojekti1.ticketguru.dto.SalesTransactionResponseDTO;
import ohjelmistoprojekti1.ticketguru.model.SalesTransaction;
import ohjelmistoprojekti1.ticketguru.repository.SalesTransactionRepository;
import ohjelmistoprojekti1.ticketguru.repository.TicketRepository;
import ohjelmistoprojekti1.ticketguru.service.SalesTransactionService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/sales")

public class SalesTransactionRestController {

    @Autowired
    private SalesTransactionService salesTransactionService;

    @Autowired
    private SalesTransactionRepository salesTransactionRepository;

    @Autowired
    TicketRepository ticketRepository;

    @GetMapping
    public ResponseEntity<Iterable<SalesTransaction>> getAllEvents() {
        Iterable<SalesTransaction> transactions = salesTransactionRepository.findAll();
        if (!transactions.iterator().hasNext()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No sales transactions found");
        }
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/{id}")
    public SalesTransaction getSalesTransactionById(@PathVariable Long id) {
        return salesTransactionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sales transaction not found"));
    }

    // Post-controller ottaa parametrinä SalesTransactionRequestDTO-muotoisen
    // requestbodyn
    // Controller luo SalesTransactionResponseDTO-muotoisen responsen, joka haetaan
    // SalesTransactionService-luokasta,
    // ja lopuksi palauttaa responsen
    @PostMapping
    public ResponseEntity<SalesTransactionResponseDTO> createSalesTransaction(
            @Valid @RequestBody SalesTransactionRequestDTO request) {
        SalesTransactionResponseDTO response = salesTransactionService.createSalesTransaction(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalesTransaction(@PathVariable Long id) {
        if (!salesTransactionRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        salesTransactionRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
