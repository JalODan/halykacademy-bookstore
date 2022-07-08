package kz.halykacademy.bookstore.models;

import java.time.LocalDate;
import java.util.List;

public class Author {

    private Long id;
    private String lastname;
    private String firstname;
    private String fathername;
    private LocalDate dateOfBirth;
    private List<Book> books;

}
