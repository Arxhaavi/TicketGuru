package ohjelmistoprojekti1.ticketguru.domain;


import java.util.List;

public class SalesTransactionRequestDTO {
    //SalestransactionDTO luokka määrittää, missä muodossa requesbody uuden salestransactionin luomisessa tulee laittaa.
    //Requestbodyssa välitetään TicketpurchaserequestDTO-muotoinen tickets-lista, jolla on TicketpurchaseRequestDTO-luokassa määritellyt ominaisuudet
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
