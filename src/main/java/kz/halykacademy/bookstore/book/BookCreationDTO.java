package kz.halykacademy.bookstore.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookCreationDTO {

    private String title;
    private Integer releaseYear;
    private Integer numberOfPages;
    private Double price;
    private Long publisherID;

    public Book toBook() {

        return Book.builder()
                .title(title)
                .releaseYear(releaseYear)
                .numberOfPages(numberOfPages)
                .price(price)
                .build();
    }
}
