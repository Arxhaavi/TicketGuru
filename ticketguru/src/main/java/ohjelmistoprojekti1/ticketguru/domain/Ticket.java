package ohjelmistoprojekti1.ticketguru.domain;

import jakarta.persistence.*;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ticket_id;

    @ManyToOne
    @JoinColumn(name = "TicketTypeId", nullable = false)
    private TicketType ticketType;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    private boolean ticketUsed;

    private double price;

    public Ticket() {

    }

    public Ticket(TicketType ticketType, Event event, Boolean ticketUsed, Double price) {
        this.ticketType = ticketType;
        this.event = event;
        this.ticketUsed = ticketUsed;
        this.price = price;
    }

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

    @Override
    public String toString() {
        return "Ticket [ticketId=" + ticket_id + ", ticketType=" + ticketType + ", event=" + event + ", price=" + price
                + ", ticketUsed="
                + ticketUsed + "]";
    }

}
