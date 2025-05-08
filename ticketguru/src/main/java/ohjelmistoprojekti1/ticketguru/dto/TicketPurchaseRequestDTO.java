package ohjelmistoprojekti1.ticketguru.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

// DTO-luokka lipun ostopyynnölle
// Käytetään lipun ostamisen yhteydessä, jotta voidaan validoida pyyntö ennen sen käsittelyä
public class TicketPurchaseRequestDTO {

    @NotNull(message = "Event ID cannot be null")
    private Long eventId;

    @NotNull(message = "Ticket type cannot be null")
    private Long ticketTypeId;

    @Min(value = 1, message = "Count must be at least 1")
    private int count;

    public TicketPurchaseRequestDTO(Long eventId, Long ticketTypeId, int count) {
        this.eventId = eventId;
        this.ticketTypeId = ticketTypeId;
        this.count = count;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getTicketTypeId() {
        return ticketTypeId;
    }

    public void setTicketTypeId(Long ticketTypeId) {
        this.ticketTypeId = ticketTypeId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
