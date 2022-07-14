package kz.halykacademy.bookstore.Publisher;

import kz.halykacademy.bookstore.book.Book;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/publisher")
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping
    public List<Publisher> getAll() {

        return publisherService.getAll();
    }

    @GetMapping("/{id}")
    public Publisher getById(@PathVariable Long id) {
        return publisherService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        publisherService.delete(id);
    }

    @PostMapping
    public void create(@RequestBody Publisher publisher) {
        publisherService.create(publisher);
    }

    @PutMapping
    public void update(@RequestBody Publisher publisher) {
        publisherService.update(publisher);
    }
}
