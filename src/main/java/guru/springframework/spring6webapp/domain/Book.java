/* Copyright Alcon 2023 */
package guru.springframework.spring6webapp.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity // JPA entity, defines that a class can be mapped to a table
public class Book {

    @ManyToMany // books can have many authors
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"),
                    inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // database generates this
    private Long        id;

    private String      isbn;

    @ManyToOne // books will only have 1 publisher
    private Publisher   publisher;

    private String      title;

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
        final Book other = (Book) obj;
        return Objects.equals(this.id, other.id);
    }

    public Set<Author> getAuthors() {
        return this.authors;
    }

    public Long getId() {
        return this.id;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public Publisher getPublisher() {
        return this.publisher;
    }

    public String getTitle() {
        return this.title;
    }

    @Override
    // for hibernate to determine if 2 objects are the same
    public int hashCode() {
        return Objects.hash(this.id);
    }

    public void setAuthors(final Set<Author> authors) {
        this.authors = authors;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setIsbn(final String isbn) {
        this.isbn = isbn;
    }

    public void setPublisher(final Publisher publisher) {
        this.publisher = publisher;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book [authors=" + this.authors + ", id=" + this.id + ", isbn=" + this.isbn + ", title=" + this.title + "]";
    }

}
