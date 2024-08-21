/* Copyright Alcon 2023 */
package guru.springframework.spring6webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.spring6webapp.domain.Book;

// Spring Data JPA will generate the implementation at runtime
public interface BookRepository extends CrudRepository<Book, Long> {

}
