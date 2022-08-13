package kz.halykacademy.bookstore.order;

import kz.halykacademy.bookstore.book.Book;
import kz.halykacademy.bookstore.book.BookService;
import kz.halykacademy.bookstore.order.item.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final BookService bookService;

    public OrderService(OrderRepository orderRepository, BookService bookService) {
        this.orderRepository = orderRepository;
        this.bookService = bookService;
    }

    private boolean isSatisfiable(Order order) {

        return order.getItems().stream().noneMatch(
                item -> item.getBook().getAvailable() < item.getAmount()
        );
    }

    public void create(Order order) {

        if (!isSatisfiable(order)) {
            throw new IllegalStateException("Requested amount exceeds the available");
        }

        for (Item item : order.getItems()) {

            Book book = item.getBook();
            book.setAvailable(book.getAvailable() - item.getAmount());
            bookService.update(book);
        }

        orderRepository.save(order);
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order getByID(Long id) {
        return orderRepository.findById(id).orElseThrow();
    }

    public void setStatus(Order order, Status status) {

        order.setStatus(status);
        orderRepository.save(order);
    }
}
