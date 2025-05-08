package ohjelmistoprojekti1.ticketguru.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

// Location-luokka, joka edustaa tapahtumapaikan tietoja tietokannassa
@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "locationid")
    private Long locationId;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Street address is mandatory")
    @Size(min = 2, max = 50, message = "Street address must be between 2 and 50 characters")
    @Column(name = "streetaddress")
    private String streetAddress;

    @NotNull(message = "Postalcode is mandatory")
    @Valid
    @ManyToOne
    @JoinColumn(name = "postalcode")
    private Postalcode postalcode;

    @NotNull(message = "Capacity is mandatory")
    @Min(value = 1, message = "Capacity must be at least 1")
    private Integer capacity;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Event> events;

    public Location() {

    }

    public Location(String name, String streetAddress, Postalcode postalcode, Integer capacity) {
        this.name = name;
        this.streetAddress = streetAddress;
        this.postalcode = postalcode;
        this.capacity = capacity;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public Postalcode getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(Postalcode postalcode) {
        this.postalcode = postalcode;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "Location [id=" + locationId + ", name=" + name + ", streetAddress=" + streetAddress + ", postalcode="
                + postalcode + ", capacity=" + capacity + ", events=" + events + "]";
    }

}
