package kz.halykacademy.bookstore.order.item;

import kz.halykacademy.bookstore.book.Book;
import kz.halykacademy.bookstore.order.Order;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Book book;
    private Integer amount;
}
