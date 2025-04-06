package ohjelmistoprojekti1.ticketguru.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "postalcode")
public class Postalcode {

    @Id
    @Column(name = "postalcode")
    private String postalcode;

    @NotBlank(message = "City is mandatory")
    @Size(min = 2, max = 100, message = "City must be between 2 and 100 characters")
    @Column(name = "city")
    private String city;

    @NotBlank(message = "Country is mandatory")
    @Size(min = 2, max = 100, message = "Country must be between 2 and 100 characters")
    @Column(name = "country")
    private String country;

    public Postalcode() {
    }

    public Postalcode(String postalcode, String city, String country) {
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
