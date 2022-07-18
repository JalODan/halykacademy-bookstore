package kz.halykacademy.bookstore.author;

import kz.halykacademy.bookstore.book.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorCreationDTO {

    private String lastname;
    private String firstname;
    private String fathername;
    private LocalDate dateOfBirth;

    public Author toAuthor() {

        return Author.builder()
                .lastname(lastname)
                .firstname(firstname)
                .fathername(fathername)
                .dateOfBirth(dateOfBirth)
                .build();
    }
}
