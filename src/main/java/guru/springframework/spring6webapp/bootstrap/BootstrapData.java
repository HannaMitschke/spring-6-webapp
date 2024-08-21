/* Copyright Alcon 2023 */
package guru.springframework.spring6webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import guru.springframework.spring6webapp.repositories.PublisherRepository;

@Component // (spring component, spring will see this and create a spring bean for it)
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository    authorRepository;

    private final BookRepository      bookRepository;

    private final PublisherRepository publisherRepository;

    public BootstrapData(final AuthorRepository authorRepository, final BookRepository bookRepository,
                    final PublisherRepository publisherRepository) {
        super();
        // spring data JPA gives us implementation, loaded in context as spring bean
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(final String... args) throws Exception {
        final Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        final Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        final Publisher aw = new Publisher();
        aw.setPublisherName("Addison-Wesley");
        aw.setAddress("75 Arlington Street Suite 300");
        aw.setCity("Boston");
        aw.setState("Massachusetts");
        aw.setZip("02116");

        // a new object is returned by the repository interface
        // h2 database sets the id property for us
        final Author ericSaved = this.authorRepository.save(eric);
        final Book dddSaved = this.bookRepository.save(ddd);
        final Publisher awSaved = this.publisherRepository.save(aw);

        final Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        final Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("54757585");

        final Publisher wrox = new Publisher();
        wrox.setPublisherName("Wrox");
        wrox.setAddress("388 Atlantic Ave");
        wrox.setCity("Brooklyn");
        wrox.setState("New York");
        wrox.setZip("11217");

        final Author rodSaved = this.authorRepository.save(rod);
        final Book noEJBSaved = this.bookRepository.save(noEJB);
        final Publisher wroxSaved = this.publisherRepository.save(wrox);

        // build association between authors and books, have to maintain both sides
        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);
        dddSaved.getAuthors().add(ericSaved);
        noEJBSaved.getAuthors().add(rodSaved);

        // build association between books and publishers
        dddSaved.setPublisher(awSaved);
        noEJBSaved.setPublisher(wroxSaved);

        // save the book association to persist it to in-memory database
        this.authorRepository.save(ericSaved);
        this.authorRepository.save(rodSaved);
        // save the publisher association to persist it to database
        this.bookRepository.save(dddSaved);
        this.bookRepository.save(noEJBSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + this.authorRepository.count());
        System.out.println("Book Count: " + this.bookRepository.count());
        System.out.println("Publisher Count: " + this.publisherRepository.count());

    }
}
