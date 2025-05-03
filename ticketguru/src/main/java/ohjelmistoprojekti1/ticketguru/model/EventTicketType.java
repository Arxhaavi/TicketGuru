package ohjelmistoprojekti1.ticketguru.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "eventtickettype")
public class EventTicketType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "eventtickettypeid")
    private Long eventTicketTypeId;

    @NotNull(message = "Event cannot be null")
    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    @JsonIgnore
    private Event event;

    @NotNull(message = "Ticket cannot be null")
    @ManyToOne
    @JoinColumn(name = "tickettypeid", nullable = false)
    private TicketType ticketType;

    @Column(name = "price", nullable = false)
    @Min(value = 0, message = "Price cannot be negative")
    private double price;

    public EventTicketType() {
    }

    public EventTicketType(Event event, TicketType ticketType, double price) {
        this.event = event;
        this.ticketType = ticketType;
        this.price = price;
    }

    public Long getEventTicketTypeId() {
        return eventTicketTypeId;
    }

    public void setEventTicketTypeId(Long eventTicketTypeId) {
        this.eventTicketTypeId = eventTicketTypeId;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
