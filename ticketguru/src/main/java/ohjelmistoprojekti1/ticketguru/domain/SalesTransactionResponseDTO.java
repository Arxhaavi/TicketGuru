package ohjelmistoprojekti1.ticketguru.domain;

import java.time.LocalDateTime;
import java.util.List;


   
public class SalesTransactionResponseDTO {
    private Long salesTransactionId;
    private List<Long> ticketIds;
    private double totalSum;
    
    public SalesTransactionResponseDTO(Long salesTransactionId, List<Long> ticketIds, double totalSum) {
        this.salesTransactionId = salesTransactionId;
        this.ticketIds = ticketIds;
        this.totalSum = totalSum;
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


    
}