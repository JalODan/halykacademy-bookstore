package kz.halykacademy.bookstore.author;

import kz.halykacademy.bookstore.genre.Genre;
import kz.halykacademy.bookstore.book.Book;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lastname;
    private String firstname;
    private String fathername;
    private LocalDate dateOfBirth;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;
    @ManyToMany
    private Set<Genre> genres;
}
