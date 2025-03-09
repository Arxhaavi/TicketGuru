// package ohjelmistoprojekti1.ticketguru.domain;
// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// Laitetaan myöhemmin päälle jos käytetään tätä entityä

// @Entity
// public class Payment {

// @Id
// @GeneratedValue(strategy = GenerationType.IDENTITY)
// private Long paymentId;

// @OneToOne
// @JoinColumn(name = "transactionId")
// private SalesTransaction salesTransaction;

// private String paymentMethod;

// private String paymentStatus;

// private LocalDateTime paymentTime;

// private double paymentAmount;

// public Payment() {}

// public Long getPaymentId() {
// return paymentId;
// }

// public void setPaymentId(Long paymentId) {
// this.paymentId = paymentId;
// }

// public SalesTransaction getSalesTransaction() {
// return salesTransaction;
// }

// public void setSalesTransaction(SalesTransaction salesTransaction) {
// this.salesTransaction = salesTransaction;
// }

// public String getPaymentMethod() {
// return paymentMethod;
// }

// public void setPaymentMethod(String paymentMethod) {
// this.paymentMethod = paymentMethod;
// }

// public String getPaymentStatus() {
// return paymentStatus;
// }

// public void setPaymentStatus(String paymentStatus) {
// this.paymentStatus = paymentStatus;
// }

// public LocalDateTime getPaymentTime() {
// return paymentTime;
// }

// public void setPaymentTime(LocalDateTime paymentTime) {
// this.paymentTime = paymentTime;
// }

// public double getPaymentAmount() {
// return paymentAmount;
// }

// public void setPaymentAmount(double paymentAmount) {
// this.paymentAmount = paymentAmount;
// }

// @Override
// public String toString() {
// return "Payment [paymentId=" + paymentId + ", salesTransaction=" +
// salesTransaction + ", paymentMethod="
// + paymentMethod + ", paymentStatus=" + paymentStatus + ", paymentTime=" +
// paymentTime
// + ", paymentAmount=" + paymentAmount + "]";
// }

// }
