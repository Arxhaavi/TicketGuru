// package ohjelmistoprojekti1.ticketguru.domain;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.OneToMany;
// import jakarta.persistence.OneToOne;
// import java.util.List;

// @Entity
// public class SalesTransactionTickets {

//     @Id
//     @GeneratedValue(strategy = GenerationType.AUTO)
//     private Long salesTransactionTickets_id;

//     @OneToMany
//     @JoinColumn(name = "ticket_id", nullable = true)
//     private List<Ticket> tickets;

//     @OneToOne
//     @JoinColumn(name = "transactionId")
//     private SalesTransaction salesTransaction;

//     public SalesTransactionTickets(SalesTransaction salesTransaction) {
//         this.salesTransaction = salesTransaction;

//     }

//     public Long getSalesTransactionTickets_id() {
//         return salesTransactionTickets_id;
//     }

//     public void setSalesTransactionTickets_id(Long salesTransactionTickets_id) {
//         this.salesTransactionTickets_id = salesTransactionTickets_id;
//     }

//     public List<Ticket> getTickets() {
//         return tickets;
//     }

//     public void setTickets(List<Ticket> tickets) {
//         this.tickets = tickets;
//     }

//     public SalesTransaction getSalesTransaction() {
//         return salesTransaction;
//     }

//     public void setSalesTransaction(SalesTransaction salesTransaction) {
//         this.salesTransaction = salesTransaction;
//     }

//     @Override
//     public String toString() {
//         return "SalesTransactionTickets [id=" + salesTransactionTickets_id + ", tickets=" + tickets + ", salesTransaction=" + salesTransaction + "]";
//     }
// }
