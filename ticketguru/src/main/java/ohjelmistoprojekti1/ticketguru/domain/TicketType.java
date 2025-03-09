package ohjelmistoprojekti1.ticketguru.domain;

import jakarta.persistence.*;

@Entity
public class TicketType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ticketTypeId;

    @OneToMany
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @Column(length = 50, nullable = false)
    private String ticketType;

    public TicketType() {
    }

    public TicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public Long getTicketTypeId() {
        return ticketTypeId;
    }

    public void setTicketTypeId(Long ticketTypeId) {
        this.ticketTypeId = ticketTypeId;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    @Override
    public String toString() {
        return "TicketType [ticketTypeId=" + ticketTypeId + ", ticketType=" + ticketType + ", ticket=" + ticket + "]";
    }
}
