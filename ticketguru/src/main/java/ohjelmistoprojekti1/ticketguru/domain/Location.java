package ohjelmistoprojekti1.ticketguru.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String streetAddress;

    @ManyToOne
    @JoinColumn(name = "postalcode")
    private Postalcode postalcode;

    private int capacity;

    @OneToMany(mappedBy = "location")
    @JsonIgnore
    private List<Event> events;

    public Location() {

    }

    public Location(String name, String streetAddress, Postalcode postalcode, int capacity) {
        this.name = name;
        this.streetAddress = streetAddress;
        this.postalcode = postalcode;
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setCapacity(int capacity) {
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
        return "Location [id=" + id + ", name=" + name + ", streetAddress=" + streetAddress + ", postalcode="
                + postalcode + ", capacity=" + capacity + ", events=" + events + "]";
    }

}
