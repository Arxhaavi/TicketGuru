package ohjelmistoprojekti1.ticketguru.web;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ohjelmistoprojekti1.ticketguru.domain.SalesTransaction;
import ohjelmistoprojekti1.ticketguru.domain.SalesTransactionRepository;
import ohjelmistoprojekti1.ticketguru.domain.Ticket;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/sales")

public class SalesTransactionRestController {

    @Autowired
    private SalesTransactionRepository salesTransactionRepository;

    @GetMapping
    public Iterable<SalesTransaction> getAllEvents() {
        return salesTransactionRepository.findAll();
    }

    @GetMapping("/{id}")
    public SalesTransaction getSalesTransactionById(@PathVariable Long id) {
        return salesTransactionRepository.findById(id).orElse(null);
    }

    @PostMapping
    public SalesTransaction createSalesTransaction(@RequestBody SalesTransaction salesTransaction) {
        salesTransaction.setTransactionTime(LocalDateTime.now());

        return salesTransactionRepository.save(salesTransaction);
    }

    @DeleteMapping("/id")
    public void deleteSalesTransaction(@PathVariable Long id) {
        salesTransactionRepository.deleteById(id);
    }
    
    

}
