package kz.halykacademy.bookstore.book;

import kz.halykacademy.bookstore.Publisher.Publisher;
import kz.halykacademy.bookstore.Publisher.PublisherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/v1/book")
public class BookController {

    private final BookService bookService;
    private final PublisherService publisherService;

    public BookController(BookService bookService, PublisherService publisherService) {
        this.bookService = bookService;
        this.publisherService = publisherService;
    }

    @GetMapping
    public List<BookDTO> getAll() {

        return bookService.getAll().stream().map(BookDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public BookDTO getById(@PathVariable Long id) {

        Book book = bookService.getById(id);
        return new BookDTO(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }

    @PostMapping
    public void create(@RequestBody BookCreationDTO dto) {

        Book book = dto.toBook();
        Publisher publisher = publisherService.getById(dto.getPublisherID());
        book.setPublisher(publisher);
        bookService.create(book);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody BookCreationDTO dto) {
        Book book = dto.toBook();
        Publisher publisher = publisherService.getById(dto.getPublisherID());
        book.setPublisher(publisher);
        bookService.update(book);
    }
}
