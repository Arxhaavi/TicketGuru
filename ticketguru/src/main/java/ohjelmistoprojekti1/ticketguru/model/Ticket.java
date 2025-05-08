package ohjelmistoprojekti1.ticketguru.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

// Ticket-luokka, joka edustaa lippujen tietoja tietokannassa
@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ticket_id")
    private Long ticket_id;

    @ManyToOne
    @JoinColumn(name = "tickettypeid", nullable = false)
    @NotNull(message = "Ticket type cannot be null")
    private TicketType ticketType;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    @NotNull(message = "Event cannot be null")
    private Event event;

    @NotNull(message = "Ticket used cannot be null")
    @Column(name = "ticketused")
    private boolean ticketUsed;

    @ManyToOne
    @JoinColumn(name = "transactionid")
    @JsonIgnore
    private SalesTransaction salesTransaction;

    @NotNull(message = "Ticket code cannot be null")
    @Column(name = "code", unique = true)
    private String code;

    public Ticket() {

    }

    public Ticket(TicketType ticketType, Event event, Boolean ticketUsed, String code) {
        this.ticketType = ticketType;
        this.event = event;
        this.ticketUsed = ticketUsed;
        this.salesTransaction = null;
        this.code = code;
    }

    // Getterit ja setterit
    public Long getTicketId() {
        return ticket_id;
    }

    public void setTicketId(Long ticket_id) {
        this.ticket_id = ticket_id;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Boolean isTicketUsed() {
        return ticketUsed;
    }

    public void setTicketUsed(Boolean ticketUsed) {
        this.ticketUsed = ticketUsed;
    }

    public SalesTransaction getSalesTransaction() {
        return salesTransaction;
    }

    public void setSalesTransaction(SalesTransaction salesTransaction) {
        this.salesTransaction = salesTransaction;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Ticket [ticketId=" + ticket_id + ", ticketType=" + ticketType + ", event=" + event
                + ", code" + code + ", ticketUsed=" + ticketUsed + "]";
    }
}