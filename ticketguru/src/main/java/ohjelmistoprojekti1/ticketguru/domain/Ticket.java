package ohjelmistoprojekti1.ticketguru.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ticket_id;

    @ManyToOne
    @JoinColumn(name = "TicketTypeId", nullable = false)
    @NotNull(message = "Ticket type cannot be null")
    private TicketType ticketType;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    @NotNull(message = "Event cannot be null")
    private Event event;

    @NotNull(message = "Ticket used cannot be null")
    private boolean ticketUsed;

    @NotNull(message = "Price cannot be null")
    @Min (value = 0, message = "Price cannot be negative")
    private double price;

    @ManyToOne
    @JoinColumn(name = "transactionId")
    @JsonIgnore
    private SalesTransaction salesTransaction;

    public Ticket() {

    }

    public Ticket(TicketType ticketType, Event event, Boolean ticketUsed, Double price) {
        this.ticketType = ticketType;
        this.event = event;
        this.ticketUsed = ticketUsed;
        this.price = price;
        this.salesTransaction = null;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    @Override
    public String toString() {
        return "Ticket [ticketId=" + ticket_id + ", ticketType=" + ticketType + ", event=" + event + ", price=" + price
                + ", ticketUsed=" + ticketUsed + "]";
    }
}