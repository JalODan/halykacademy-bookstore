package kz.halykacademy.bookstore.book;

import kz.halykacademy.bookstore.Genre.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface BookRepository extends JpaRepository<Book, Long> {
    Set<Book> findByTitleContainingIgnoreCase(String partOfTitle);

    @Query(value = "select * from book\n" +
            "                  join\n" +
            "              (select books_id, count(*) cnt from book_genres where genres_id in :genres group by books_id) T\n" +
            "\n" +
            "              on book.id = T.books_id\n" +
            "\n" +
            "order by cnt desc;", nativeQuery = true)
    List<Book> findByGenres(@Param("genres") Set<Genre> genres);
}
