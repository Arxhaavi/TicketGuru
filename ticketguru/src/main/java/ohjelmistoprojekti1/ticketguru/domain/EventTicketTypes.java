package ohjelmistoprojekti1.ticketguru.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class EventTicketTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    double price;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "tickettype_id")
    private TicketType tickettype;

    public EventTicketTypes() {

    }

    public EventTicketTypes(Event event, TicketType tickettype) {
        this.event = event;
        this.tickettype = tickettype;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public TicketType getTicketType() {
        return tickettype;
    }

    public void setTicketType(TicketType tickettype) {
        this.tickettype = tickettype;
    }

    @Override
    public String toString() {
        return "EventTicketTypes [id=" + id + ", price=" + price + ", event=" + event + ", tickettype=" + tickettype + "]";
    }
}
