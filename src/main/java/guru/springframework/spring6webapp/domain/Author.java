/* Copyright Alcon 2023 */
package guru.springframework.spring6webapp.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity // JPA entity, defines that a class can be mapped to a table
public class Author {

    @ManyToMany(mappedBy = "authors") // authors can have many books
    private Set<Book> books = new HashSet<>();

    private String    firstName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // database generates this
    private Long      id;

    private String    lastName;

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
        final Author other = (Author) obj;
        return Objects.equals(this.id, other.id);
    }

    public Set<Book> getBooks() {
        return this.books;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public Long getId() {
        return this.id;
    }

    public String getLastName() {
        return this.lastName;
    }

    @Override
    // for hibernate to determine if 2 objects are the same
    public int hashCode() {
        return Objects.hash(this.id);
    }

    public void setBooks(final Set<Book> books) {
        this.books = books;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Author [books=" + this.books + ", firstName=" + this.firstName + ", id=" + this.id + ", lastName="
                        + this.lastName + "]";
    }

}
