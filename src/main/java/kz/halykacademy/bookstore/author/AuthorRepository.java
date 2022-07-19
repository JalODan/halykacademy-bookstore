package kz.halykacademy.bookstore.author;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Set<Author> getAuthorsByFirstnameContainingIgnoreCaseOrLastnameContainingIgnoreCaseOrFathernameContainingIgnoreCase(
            String lastname, String firstname, String fathername
    );
}
