package ohjelmistoprojekti1.ticketguru.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
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

    // CreateSalesTransaction-funktio luo myyntitapahtuman ja siihen kuuluvat liput
    // Funktio saa parametrina SalesTransactionRequestDTO-tyyppisen request-pyynnön
    // (käyttäjän antama json objekti)
    // Funktio palauttaa SalesTransactionResponseDTO-tyyppisen responsen
    public SalesTransactionResponseDTO createSalesTransaction(SalesTransactionRequestDTO request) {
        if (request.getTickets() == null || request.getTickets().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "At least one ticket must be associated with the transaction");
        }

        // Luo uusi myyntitapahtuma
        SalesTransaction salesTransaction = new SalesTransaction();

        // aseta myyntitapahtumalle aika
        salesTransaction.setTransactionTime(LocalDateTime.now());

        // Tallenna myyntitapahtuma
        salesTransaction = salesTransactionRepository.save(salesTransaction);

        // Luo tyhjä lista myyntitapahtumaan liitettäviä lippuja varten
        List<Ticket> tickets = new ArrayList<>();

        // Alusta myyntitapahtuman kokonaissumma
        double totalSum = 0;

        // Käydään läpi requestbodyssa annetut liput ja niiden tiedot (event,
        // ticketType, price ja count)
        for (TicketPurchaseRequestDTO ticketRequest : request.getTickets()) {

            // Tarkistetaan, että eventId ei ole null
            if (ticketRequest.getEventId() == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Event ID cannot be null");
            }

            // haetaan requestbodyssa välitetty EventId
            Event event = eventRepository.findById(ticketRequest.getEventId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Event not found"));

            // haetaan requestbodyssa välitetty ticketType
            TicketType ticketType = ticketTypeRepository.findById(ticketRequest.getTicketTypeId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ticket type not found"));

            // haetaan requestbodyssa välitetty lipun price
            double price = ticketRequest.getPrice();
            if (price < 0) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Price cannot be negative");
            }

            Integer count = ticketRequest.getCount();
            if (count == null || count <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Count must be greater than 0");
        }

            // haetaan requestbodyssa välitetty lippujen määrä count. Luodaan sen mukainen
            // määrä lippuja yllä hetuilla ominaisuuksilla ja tallennetaan myyntitapahtuman
            // tickets-listaan
            for (int i = 0; i < count; i++) {
                Ticket ticket = new Ticket();
                ticket.setEvent(event);
                ticket.setTicketType(ticketType);
                ticket.setSalesTransaction(salesTransaction);
                ticket.setPrice(price);
                ticket.setTicketUsed(false);
    
                ticket = ticketRepository.save(ticket);
                tickets.add(ticket);
                totalSum = totalSum + ticket.getPrice();
            }
        }
        // Tallennetaan myyntitapahtuman ominaisuudet; summa ja myyntitapahtuman liput
        salesTransaction.setSum(totalSum);
        salesTransaction.setTickets(tickets);
        salesTransactionRepository.save(salesTransaction);

        // Palautetaan SalesTransactionResponseDTO-tyyppinen response
        return new SalesTransactionResponseDTO(
                salesTransaction.getTransactionId(),
                tickets.stream().map(Ticket::getTicketId).toList(),
                totalSum, salesTransaction.getTransactionTime());
    }
}
