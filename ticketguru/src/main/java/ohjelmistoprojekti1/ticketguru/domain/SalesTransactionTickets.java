package ohjelmistoprojekti1.ticketguru.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class SalesTransactionTickets {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long salesTransactionTickets_id;

    @OneToMany
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @OneToOne
    @JoinColumn(name = "transactionId")
    private SalesTransaction salesTransaction;

    public SalesTransactionTickets(Ticket ticket, SalesTransaction salesTransaction) {
        this.ticket = ticket;
        this.salesTransaction = salesTransaction;

    }

    public Long getSalesTransactionTickets_id() {
        return salesTransactionTickets_id;
    }

    public void setSalesTransactionTickets_id(Long salesTransactionTickets_id) {
        this.salesTransactionTickets_id = salesTransactionTickets_id;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public SalesTransaction getSalesTransaction() {
        return salesTransaction;
    }

    public void setSalesTransaction(SalesTransaction salesTransaction) {
        this.salesTransaction = salesTransaction;
    }

    @Override
    public String toString() {
        return "SalesTransactionTickets [id=" + salesTransactionTickets_id + ", Ticket=" + ticket
                + ", SalesTransaction=" + salesTransaction + "]";
    }
}
