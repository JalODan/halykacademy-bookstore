package kz.halykacademy.bookstore.book;

import kz.halykacademy.bookstore.Genre.Genre;
import kz.halykacademy.bookstore.Publisher.Publisher;
import kz.halykacademy.bookstore.author.Author;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer releaseYear;
    private Integer numberOfPages;
    private Double price;
    @ManyToOne
    private Publisher publisher;
    @ManyToMany
    Set<Author> authors;

    @ManyToMany
    private Set<Genre> genres;
}
