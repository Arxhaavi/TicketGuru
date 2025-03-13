package ohjelmistoprojekti1.ticketguru.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

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

            // haetaan requestbodyssa välitetty EventId
            Event event = eventRepository.findById(ticketRequest.getEventId())
                    .orElseThrow(() -> new RuntimeException("Event not found"));

            // haetaan requestbodyssa välitetty ticketType
            TicketType ticketType = ticketTypeRepository.findById(ticketRequest.getTicketTypeId())
                    .orElseThrow(() -> new RuntimeException("Ticket type not found"));

            // haetaan requestbodyssa välitetty lipun price
            double price = ticketRequest.getPrice();

            // haetaan requestbodyssa välitetty lippujen määrä count. Luodaan sen mukainen
            // määrä lippuja yllä hetuilla ominaisuuksilla ja tallennetaan myyntitapahtuman
            // tickets-listaan
            for (int i = 0; i < ticketRequest.getCount(); i++) {
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

        //Palautetaan SalesTransactionResponseDTO-tyyppinen response
        return new SalesTransactionResponseDTO(
                salesTransaction.getTransactionId(),
                tickets.stream().map(Ticket::getTicketId).toList(),
                totalSum, salesTransaction.getTransactionTime());
    }
}
