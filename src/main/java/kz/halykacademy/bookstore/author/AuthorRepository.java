package kz.halykacademy.bookstore.author;

import kz.halykacademy.bookstore.Genre.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Set<Author> getAuthorsByFirstnameContainingIgnoreCaseOrLastnameContainingIgnoreCaseOrFathernameContainingIgnoreCase(
            String lastname, String firstname, String fathername
    );

    @Query(value = "select * from author join\n" +
            "(select authors_id, count(*) cnt from author_genres where genres_id in :genres group by authors_id) T\n" +
            "on author.id = T.authors_id\n" +
            "order by cnt desc;", nativeQuery = true)
    List<Author> findByGenres(@Param("genres") Set<Genre> genres);
}
