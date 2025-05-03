package ohjelmistoprojekti1.ticketguru.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

public class SalesTransactionRequestDTO {
    // SalestransactionDTO luokka määrittää, missä muodossa requesbody uuden
    // salestransactionin luomisessa tulee laittaa.
    // Requestbodyssa välitetään TicketpurchaserequestDTO-muotoinen tickets-lista,
    // jolla on TicketpurchaseRequestDTO-luokassa määritellyt ominaisuudet

    @NotEmpty(message = "At least one ticket must be associated with the transaction")
    @Valid
    private List<TicketPurchaseRequestDTO> tickets;

    public SalesTransactionRequestDTO(List<TicketPurchaseRequestDTO> tickets) {
        this.tickets = tickets;
    }

    public List<TicketPurchaseRequestDTO> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketPurchaseRequestDTO> tickets) {
        this.tickets = tickets;
    }

}
