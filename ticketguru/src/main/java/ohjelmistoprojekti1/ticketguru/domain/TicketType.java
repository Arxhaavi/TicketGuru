package ohjelmistoprojekti1.ticketguru.domain;

import jakarta.persistence.*;

@Entity
public class TicketType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ticketTypeId;

    @Column(length = 50, nullable = false)
    private String ticketType;

    public TicketType() {}

    public TicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public int getTicketTypeId() {
        return ticketTypeId;
    }

    public void setTicketTypeId(int ticketTypeId) {
        this.ticketTypeId = ticketTypeId;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    @Override
    public String toString() {
        return "TicketType [ticketTypeId=" + ticketTypeId + ", ticketType=" + ticketType + "]";
    }
}
