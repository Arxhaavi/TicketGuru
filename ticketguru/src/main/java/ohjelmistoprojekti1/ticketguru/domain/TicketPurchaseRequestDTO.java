package ohjelmistoprojekti1.ticketguru.domain;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class TicketPurchaseRequestDTO {
    private Long eventId;

    @NotNull(message = "Ticket type cannot be null")
    @NotNull(message = "Ticket type cannot be null")
    private Long ticketTypeId;

    @Min(value = 1, message = "Count must be at least 1")
    private int count;

    @NotNull(message = "Price cannot be null")
    @Min(value = 0, message = "Price cannot be negative")
    private double price;

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
    public double getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    

    
}
