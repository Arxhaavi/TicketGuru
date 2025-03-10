package ohjelmistoprojekti1.ticketguru.domain;


import java.util.List;

public class SalesTransactionRequestDTO {
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
