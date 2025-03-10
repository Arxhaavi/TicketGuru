package ohjelmistoprojekti1.ticketguru.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service

public class SalesTransactionService {
  
    @Autowired
    private SalesTransactionRepository salesTransactionRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private TicketTypeRepository ticketTypeRepository;

    @Transactional
    public SalesTransactionResponseDTO createSalesTransaction(SalesTransactionRequestDTO request) {
        SalesTransaction salesTransaction = new SalesTransaction();
        salesTransaction.setTransactionTime(LocalDateTime.now());
        salesTransaction = salesTransactionRepository.save(salesTransaction);

        List<Ticket> tickets = new ArrayList<>();
        double totalSum = 0;

        for (TicketPurchaseRequestDTO ticketRequest : request.getTickets()) {
            Event event = eventRepository.findById(ticketRequest.getEventId())
                    .orElseThrow(() -> new RuntimeException("Event not found"));

            TicketType ticketType = ticketTypeRepository.findById(ticketRequest.getTicketTypeId())
                    .orElseThrow(() -> new RuntimeException("Ticket type not found"));

            double price = ticketRequest.getPrice();         

            for (int i = 0; i < ticketRequest.getCount(); i++) {
                Ticket ticket = new Ticket();
                ticket.setEvent(event);
                ticket.setTicketType(ticketType);
                ticket.setSalesTransaction(salesTransaction);
                ticket.setPrice(price);  // Oletetaan, että TicketType sisältää hinnan
                ticket.setTicketUsed(false);

                ticket = ticketRepository.save(ticket);
                tickets.add(ticket);
                totalSum += ticket.getPrice();
            }
        }

        salesTransaction.setSum(totalSum);
        salesTransaction.setTickets(tickets);
        salesTransactionRepository.save(salesTransaction);

        return new SalesTransactionResponseDTO(
            salesTransaction.getTransactionId(),
            tickets.stream().map(Ticket::getTicketId).toList(),
            totalSum
        );
    }
}
