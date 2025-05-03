package ohjelmistoprojekti1.ticketguru.dto;

import java.time.LocalDateTime;
import java.util.List;

public class SalesTransactionResponseDTO {
    private Long salesTransactionId;
    private List<Long> ticketIds;
    private double totalSum;
    private LocalDateTime transactionTime;

    public SalesTransactionResponseDTO(Long salesTransactionId, List<Long> ticketIds, double totalSum,
            LocalDateTime transactionTime) {
        this.salesTransactionId = salesTransactionId;
        this.ticketIds = ticketIds;
        this.totalSum = totalSum;
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

    public double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }

}