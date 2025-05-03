package ohjelmistoprojekti1.ticketguru.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tickettype")
public class TicketType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tickettypeid")
    private Long ticketTypeId;

    @Column(name = "tickettype", length = 50, nullable = false)
    @NotBlank(message = "Ticket type cannot be blank")
    @Size(max = 50, message = "Ticket type cannot exceed 50 characters")
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
