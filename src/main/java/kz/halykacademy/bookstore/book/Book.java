package kz.halykacademy.bookstore.book;

import kz.halykacademy.bookstore.Publisher.Publisher;
import lombok.*;

import javax.persistence.*;

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
}
