package ohjelmistoprojekti1.ticketguru.domain;

public class TicketPurchaseRequestDTO {
    private Long eventId;
    private Long ticketTypeId;
    private int count;
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
