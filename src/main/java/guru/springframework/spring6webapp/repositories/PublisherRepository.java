/* Copyright Alcon 2023 */
package guru.springframework.spring6webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.spring6webapp.domain.Publisher;

// Spring Data JPA will generate the implementation at runtime
public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
