package kz.halykacademy.bookstore.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

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
    private Set<Long> authorIDs;
    private Set<Long> genreIDs;
    private Integer available;

    public Book toBook() {

        return Book.builder()
                .title(title)
                .releaseYear(releaseYear)
                .numberOfPages(numberOfPages)
                .price(price)
                .available(available)
                .build();
    }
}
