package ohjelmistoprojekti1.ticketguru.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SalesTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    // Laitetaan päälle jos otetaan mukaan
    // @ManyToOne
    // @JoinColumn(name = "customerId")
    // private Customer customer;

    // laitetaan päälle jos otetaan payment mukaan myöhemmin
    // @ManyToOne
    // @JoinColumn(name = "paymentId")
    // private Payment payment;

    private LocalDateTime transactionTime;

    public SalesTransaction() {
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    // public Customer getCustomer() {
    // return customer;
    // }

    // public void setCustomer(Customer customer) {
    // this.customer = customer;
    // }

    // public Payment getPayment() {
    // return payment;
    // }

    // public void setPayment(Payment payment) {
    // this.payment = payment;
    // }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }

    @Override
    public String toString() {
        return "SalesTransaction [transactionId=" + transactionId
                + ", transactionTime=" + transactionTime + "]";
    }

}
