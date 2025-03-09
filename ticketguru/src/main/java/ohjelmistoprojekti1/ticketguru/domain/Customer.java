// package ohjelmistoprojekti1.ticketguru.domain;
// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.OneToMany;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import java.util.List;

// @Entity
// public class Customer {

// @Id
// @GeneratedValue(strategy = GenerationType.IDENTITY)
// private Long customerId;
// private String firstName;
// private String lastName;
// private String streetAdress;

// @ManyToOne
// @JoinColumn(name = "postalcode")
// private Postalcode postalcode;

// private String email;
// private String phoneNumber;

// @OneToMany(mappedBy = "customer")
// private List<SalesTransaction> salesTransactions;

// public Customer() {}

// public Long getCustomerId() {
// return customerId;
// }

// public void setCustomerId(Long customerId) {
// this.customerId = customerId;
// }

// public String getFirstName() {
// return firstName;
// }

// public void setFirstName(String firstName) {
// this.firstName = firstName;
// }

// public String getLastName() {
// return lastName;
// }

// public void setLastName(String lastName) {
// this.lastName = lastName;
// }

// public String getStreetAdress() {
// return streetAdress;
// }

// public void setStreetAdress(String streetAdress) {
// this.streetAdress = streetAdress;
// }

// public Postalcode getPostalcode() {
// return postalcode;
// }

// public void setPostalcode(Postalcode postalcode) {
// this.postalcode = postalcode;
// }

// public String getEmail() {
// return email;
// }

// public void setEmail(String email) {
// this.email = email;
// }

// public String getPhoneNumber() {
// return phoneNumber;
// }

// public void setPhoneNumber(String phoneNumber) {
// this.phoneNumber = phoneNumber;
// }

// public List<SalesTransaction> getSalesTransactions() {
// return salesTransactions;
// }

// public void setSalesTransactions(List<SalesTransaction> salesTransactions) {
// this.salesTransactions = salesTransactions;
// }

// @Override
// public String toString() {
// return "Customer [customerId=" + customerId + ", firstName=" + firstName + ",
// lastName=" + lastName
// + ", streetAdress=" + streetAdress + ", postalcode=" + postalcode + ",
// email=" + email
// + ", phoneNumber=" + phoneNumber + ", salesTransactions=" + salesTransactions
// + "]";
// }

// }
