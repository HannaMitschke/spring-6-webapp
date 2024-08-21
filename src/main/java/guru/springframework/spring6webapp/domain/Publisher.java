/* Copyright Alcon 2023 */
package guru.springframework.spring6webapp.domain;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity // JPA entity, defines that a class can be mapped to a table
public class Publisher {

    private String    address;

    @OneToMany(mappedBy = "publisher") // 1 publisher goes to many different books, "publisher" is the property on book
    private Set<Book> books;

    private String    city;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // database generates this
    private Long      id;

    private String    publisherName;

    private String    state;

    private String    zip;

    @Override
    // for hibernate to determine if 2 objects are the same
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final Publisher other = (Publisher) obj;
        return Objects.equals(this.id, other.id);
    }

    public String getAddress() {
        return this.address;
    }

    public String getCity() {
        return this.city;
    }

    public Long getId() {
        return this.id;
    }

    public String getPublisherName() {
        return this.publisherName;
    }

    public String getState() {
        return this.state;
    }

    public String getZip() {
        return this.zip;
    }

    @Override
    // for hibernate to determine if 2 objects are the same
    public int hashCode() {
        return Objects.hash(this.id);
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setPublisherName(final String publisherName) {
        this.publisherName = publisherName;
    }

    public void setState(final String state) {
        this.state = state;
    }

    public void setZip(final String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Publisher [id=" + this.id + ", publisherName=" + this.publisherName + ", address=" + this.address + ", city="
                        + this.city + ", state=" + this.state + ", zip=" + this.zip + "]";
    }

}
