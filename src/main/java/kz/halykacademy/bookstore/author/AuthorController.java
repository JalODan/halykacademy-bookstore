package kz.halykacademy.bookstore.author;

import kz.halykacademy.bookstore.book.Book;
import kz.halykacademy.bookstore.book.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAll() {
        return authorService.getAll();
    }

    @GetMapping("/{id}")
    public Author getById(@PathVariable Long id) {
        return authorService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        authorService.delete(id);
    }

    @PostMapping
    public void create(@RequestBody Author author) {
        authorService.create(author);
    }

    @PutMapping
    public void update(@RequestBody Author author) {
        authorService.update(author);
    }
}
