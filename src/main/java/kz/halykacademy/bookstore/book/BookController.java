package kz.halykacademy.bookstore.book;

import org.apache.coyote.Response;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAll() {

        return bookService.getAll();
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Long id) {
        return bookService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }

    @PostMapping
    public void create(@RequestBody Book book) {
        bookService.create(book);
    }

    @PutMapping
    public void update(@RequestBody Book book) {
        bookService.update(book);
    }
}
