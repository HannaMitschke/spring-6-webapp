/* Copyright Alcon 2023 */
package guru.springframework.spring6webapp.services;

import guru.springframework.spring6webapp.domain.Book;

// when you are injecting components, best practice is to write to interface
public interface BookService {

    Iterable<Book> findAll();
}
