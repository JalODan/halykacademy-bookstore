package kz.halykacademy.bookstore.Publisher;

import kz.halykacademy.bookstore.book.Book;
import kz.halykacademy.bookstore.book.BookDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PublisherDTO {

    private Long id;
    private String name;
    private List<Long> bookIDs;

    public PublisherDTO(Publisher publisher) {

        this.id = publisher.getId();
        this.name = publisher.getName();
        this.bookIDs = publisher.getBooks().stream().map(Book::getId).collect(Collectors.toList());
    }
}
