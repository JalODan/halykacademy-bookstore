package kz.halykacademy.bookstore.book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface BookRepository extends JpaRepository<Book, Long> {
    Set<Book> findByTitleContainingIgnoreCase(String partOfTitle);
}
