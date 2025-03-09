package ohjelmistoprojekti1.ticketguru.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Postalcode {

    @Id
    private String postalcode;

    @OneToMany
    @JoinColumn(name = "location_id")
    private Location location;

    private String city;
    private String country;

    public Postalcode() {
    }

    public Postalcode(String postalcode, String city, String country, Location location) {
        this.postalcode = postalcode;
        this.city = city;
        this.country = country;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Postalcode [postalcode=" + postalcode + ", city=" + city + ", country=" + country + "]";
    }
}
