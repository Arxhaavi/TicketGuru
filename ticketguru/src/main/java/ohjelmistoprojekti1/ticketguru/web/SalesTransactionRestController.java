package ohjelmistoprojekti1.ticketguru.web;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ohjelmistoprojekti1.ticketguru.domain.SalesTransaction;
import ohjelmistoprojekti1.ticketguru.domain.SalesTransactionRepository;
import ohjelmistoprojekti1.ticketguru.domain.SalesTransactionRequestDTO;
import ohjelmistoprojekti1.ticketguru.domain.SalesTransactionResponseDTO;
import ohjelmistoprojekti1.ticketguru.domain.SalesTransactionService;
import ohjelmistoprojekti1.ticketguru.domain.Ticket;
import ohjelmistoprojekti1.ticketguru.domain.TicketRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
    public Iterable<SalesTransaction> getAllEvents() {
        return salesTransactionRepository.findAll();
    }

    @GetMapping("/{id}")
    public SalesTransaction getSalesTransactionById(@PathVariable Long id) {
        return salesTransactionRepository.findById(id).orElse(null);
    }

    // Post-controller ottaa parametrinä SalesTransactionRequestDTO-muotoisen
    // requestbodyn
    // Controller luo SalesTransactionResponseDTO-muotoisen responsen, joka haetaan
    // SalesTransactionService-luokasta,
    // ja lopuksi palauttaa responsen
    @PostMapping
    public ResponseEntity<SalesTransactionResponseDTO> createSalesTransaction(
            @RequestBody SalesTransactionRequestDTO request) {
        SalesTransactionResponseDTO response = salesTransactionService.createSalesTransaction(request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/id")
    public void deleteSalesTransaction(@PathVariable Long id) {
        salesTransactionRepository.deleteById(id);
    }

}
