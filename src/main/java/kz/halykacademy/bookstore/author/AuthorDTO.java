package kz.halykacademy.bookstore.author;

import kz.halykacademy.bookstore.genre.Genre;
import kz.halykacademy.bookstore.book.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO {

    private Long id;
    private String lastname;
    private String firstname;
    private String fathername;
    private LocalDate dateOfBirth;
    private Set<Long> bookIDs;
    private Set<Long> genreIDs;

    public AuthorDTO(Author author) {

        this.id = author.getId();
        this.lastname = author.getLastname();
        this.firstname = author.getFirstname();
        this.fathername = author.getFathername();
        this.dateOfBirth = author.getDateOfBirth();
        this.bookIDs = author.getBooks().stream().map(Book::getId).collect(Collectors.toSet());
        this.genreIDs = author.getGenres().stream().map(Genre::getId).collect(Collectors.toSet());
    }
}
