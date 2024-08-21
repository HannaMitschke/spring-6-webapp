/* Copyright Alcon 2023 */
package guru.springframework.spring6webapp.services;

import org.springframework.stereotype.Service;

import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.repositories.BookRepository;

@Service
// service layer to be working with business logic to retrieve data from the persistence layer
// abstracting persistence logic from controllers by placing it into a service
// working w controller (MVC)
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    // book repo will get injected by spring framework
    public BookServiceImpl(final BookRepository bookRepository) {
        super();
        this.bookRepository = bookRepository;
    }

    @Override // override helps prevent from accidentally implementing a method not defined by the interface
    // find all books in database
    public Iterable<Book> findAll() {
        return this.bookRepository.findAll();
    }

}
