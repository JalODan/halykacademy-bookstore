package kz.halykacademy.bookstore.genre;

import kz.halykacademy.bookstore.author.Author;
import kz.halykacademy.bookstore.book.Book;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "genres")
    private Set<Author> authors;

    @ManyToMany(mappedBy = "genres")
    private Set<Book> books;
}
