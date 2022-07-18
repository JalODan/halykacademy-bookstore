package kz.halykacademy.bookstore.author;

import kz.halykacademy.bookstore.book.Book;
import kz.halykacademy.bookstore.book.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/v1/author")
public class AuthorController {

    private final AuthorService authorService;
    private final BookService bookService;

    public AuthorController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @GetMapping
    public Set<AuthorDTO> getAll() {
        return authorService.getAll().stream().map(AuthorDTO::new).collect(Collectors.toSet());
    }

    @GetMapping("/{id}")
    public AuthorDTO getById(@PathVariable Long id) {
        return new AuthorDTO(authorService.getById(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        authorService.delete(id);
    }

    @PostMapping
    public void create(@RequestBody AuthorCreationDTO dto) {

        Author author = dto.toAuthor();
        authorService.create(author);
    }

    @PutMapping
    public void update(@RequestBody Author author) {
        authorService.update(author);
    }
}
