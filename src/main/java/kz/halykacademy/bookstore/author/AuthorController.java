package kz.halykacademy.bookstore.author;

import kz.halykacademy.bookstore.genre.Genre;
import kz.halykacademy.bookstore.genre.GenreService;
import kz.halykacademy.bookstore.book.BookService;
import kz.halykacademy.bookstore.common.dto.SearchByGenresDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/v1/author")
public class AuthorController {

    private final AuthorService authorService;
    private final BookService bookService;
    private final GenreService genreService;

    public AuthorController(AuthorService authorService, BookService bookService, GenreService genreService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.genreService = genreService;
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

        Set<Genre> genres = dto.getGenreIDs().stream().map(genreService::getById).collect(Collectors.toSet());

        Author author = dto.toAuthor();
        author.setGenres(genres);

        authorService.create(author);
    }

    @PutMapping
    public void update(@RequestBody AuthorCreationDTO dto) {
        Set<Genre> genres = dto.getGenreIDs().stream().map(genreService::getById).collect(Collectors.toSet());

        Author author = dto.toAuthor();
        author.setGenres(genres);

        authorService.update(author);
    }

    @GetMapping("/search/byName/{partOfName}")
    public Set<AuthorDTO> findByName(@PathVariable String partOfName) {

        return authorService.findByName(partOfName).stream().map(AuthorDTO::new).collect(Collectors.toSet());
    }

    @GetMapping("/search/byGenres")
    public List<AuthorDTO> findByGenres(@RequestBody SearchByGenresDTO dto) {

        Set<Genre> genres = dto.getGenreIDs().stream().map(genreService::getById).collect(Collectors.toSet());
        return authorService.findByGenres(genres).stream().map(AuthorDTO::new).collect(Collectors.toList());
    }
}
