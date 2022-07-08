package kz.halykacademy.bookstore.models;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;

public class Book {

    private Long id;
    private Double price;
    private List<Author> authors;
    private String title;
    private int numberOfPages;
    private Year releaseYear;

}
