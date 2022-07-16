package kz.halykacademy.bookstore.book;

import kz.halykacademy.bookstore.Publisher.PublisherDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    private Long id;
    private String title;
    private Integer releaseYear;
    private Integer numberOfPages;
    private Double price;
    private Long publisherID;
    public BookDTO(Book book) {

        this.id = book.getId();
        this.title = book.getTitle();
        this.releaseYear = book.getReleaseYear();
        this.numberOfPages = book.getNumberOfPages();
        this.price = book.getPrice();
        this.publisherID = book.getPublisher().getId();
    }
}
