package kz.halykacademy.bookstore.book;

import kz.halykacademy.bookstore.Genre.Genre;
import kz.halykacademy.bookstore.Genre.GenreService;
import kz.halykacademy.bookstore.Publisher.Publisher;
import kz.halykacademy.bookstore.Publisher.PublisherService;
import kz.halykacademy.bookstore.author.Author;
import kz.halykacademy.bookstore.author.AuthorService;
import kz.halykacademy.bookstore.common.dto.SearchByGenresDTO;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/v1/book")
public class BookController {

    private final BookService bookService;
    private final PublisherService publisherService;
    private final AuthorService authorService;
    private final GenreService genreService;

    public BookController(BookService bookService, PublisherService publisherService, AuthorService authorService, GenreService genreService) {
        this.bookService = bookService;
        this.publisherService = publisherService;
        this.authorService = authorService;
        this.genreService = genreService;
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

        Set<Author> authors = dto.getAuthorIDs().stream().map(authorService::getById).collect(Collectors.toSet());
        book.setAuthors(authors);

        Set<Genre> genres = dto.getGenreIDs().stream().map(genreService::getById).collect(Collectors.toSet());
        book.setGenres(genres);

        bookService.create(book);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody BookCreationDTO dto) {

        Book book = dto.toBook();
        book.setId(id);

        Publisher publisher = publisherService.getById(dto.getPublisherID());
        book.setPublisher(publisher);

        Set<Author> authors = dto.getAuthorIDs().stream().map(authorService::getById).collect(Collectors.toSet());
        book.setAuthors(authors);

        Set<Genre> genres = dto.getGenreIDs().stream().map(genreService::getById).collect(Collectors.toSet());
        book.setGenres(genres);

        bookService.update(book);
    }

    @GetMapping("/search/{partOfTitle}")
    public Set<BookDTO> findByTitle(@PathVariable String partOfTitle) {

        return bookService.findByTitle(partOfTitle).stream().map(BookDTO::new).collect(Collectors.toSet());
    }

    @GetMapping("/search/byGenres")
    public List<BookDTO> findByGenres(@RequestBody SearchByGenresDTO dto) {

        Set<Genre> genres = dto.getGenreIDs().stream().map(genreService::getById).collect(Collectors.toSet());
        return bookService.findByGenres(genres).stream().map(BookDTO::new).collect(Collectors.toList());
    }
}
