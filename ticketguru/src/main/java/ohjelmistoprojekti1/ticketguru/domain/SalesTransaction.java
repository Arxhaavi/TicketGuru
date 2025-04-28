package ohjelmistoprojekti1.ticketguru.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.engine.internal.Cascade;

import jakarta.validation.constraints.*;

@Entity
@Table(name = "salestransaction")
public class SalesTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transactionid")
    private Long transactionId;

    // Laitetaan päälle jos otetaan mukaan
    // @ManyToOne
    // @JoinColumn(name = "customerId")
    // private Customer customer;

    // laitetaan päälle jos otetaan payment mukaan myöhemmin
    // @ManyToOne
    // @JoinColumn(name = "paymentId")
    // private Payment payment;

    @NotNull(message = "Transaction time is mandatory")
    @Column(name = "transactiontime")
    private LocalDateTime transactionTime;

    @NotNull(message = "Sum is mandatory")
    @DecimalMin(value = "0.0", message = "Sum must be at least 0")
    @Column(name = "sum")
    private double sum;

    @NotNull(message = "Tickets cannot be null")
    @OneToMany(mappedBy = "salesTransaction", cascade = CascadeType.ALL)
    private List<Ticket> tickets = new ArrayList<>();

    @AssertTrue(message = "Sales transaction must have at least one ticket")
    public boolean hasTickets() {
        return tickets != null && !tickets.isEmpty();
    }

    public SalesTransaction() {
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
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
