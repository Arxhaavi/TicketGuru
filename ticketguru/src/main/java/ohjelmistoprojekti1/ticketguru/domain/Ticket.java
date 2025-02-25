package ohjelmistoprojekti1.ticketguru.domain;

import jakarta.persistence.*;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long ticketId;

    @ManyToOne
    @JoinColumn(name = "ticket_type_id", nullable = false)
    private TicketType ticketType;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    private boolean ticketUsed;

    public Ticket() {

    }

    public Ticket(TicketType ticketType, Event event, boolean ticketUsed) {
        this.ticketType = ticketType;
        this.event = event;
        this.ticketUsed = ticketUsed;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
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

    public boolean isTicketUsed() {
        return ticketUsed;
    }

    public void setTicketUsed(boolean ticketUsed) {
        this.ticketUsed = ticketUsed;
    }

    @Override
    public String toString() {
        return "Ticket [ticketId=" + ticketId + ", ticketType=" + ticketType + ", event=" + event + ", ticketUsed=" + ticketUsed + "]";
    }



}
