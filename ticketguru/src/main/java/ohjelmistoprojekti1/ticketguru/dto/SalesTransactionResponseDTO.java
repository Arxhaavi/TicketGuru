package ohjelmistoprojekti1.ticketguru.dto;

import java.time.LocalDateTime;
import java.util.List;

// Uuden myyntitapahtuman DTO-luokka, joka sisältää tiedot lipuista ja myyntitapahtumasta
public class SalesTransactionResponseDTO {
    private Long salesTransactionId;
    private List<Long> ticketIds;
    private LocalDateTime transactionTime;

    public SalesTransactionResponseDTO(Long salesTransactionId, List<Long> ticketIds,
            LocalDateTime transactionTime) {
        this.salesTransactionId = salesTransactionId;
        this.ticketIds = ticketIds;
        this.transactionTime = transactionTime;
    }

    public Long getSalesTransactionId() {
        return salesTransactionId;
    }

    public void setSalesTransactionId(Long salesTransactionId) {
        this.salesTransactionId = salesTransactionId;
    }

    public List<Long> getTicketIds() {
        return ticketIds;
    }

    public void setTicketIds(List<Long> ticketIds) {
        this.ticketIds = ticketIds;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }

}