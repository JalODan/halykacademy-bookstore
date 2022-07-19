package kz.halykacademy.bookstore.Publisher;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    Set<Publisher> findByNameContainingIgnoreCase(String partOfName);
}
