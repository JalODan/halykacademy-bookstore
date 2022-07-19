package kz.halykacademy.bookstore.Genre;

import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/v1/genre")
public class GenreController {

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public Set<GenreDTO> getAll() {

        return genreService.getAll().stream().map(GenreDTO::new).collect(Collectors.toSet());
    }

    @PostMapping
    public void create(@RequestBody GenreCreationDTO dto) {

        Genre genre = dto.toGenre();
        genreService.create(genre);
    }

    @GetMapping("/{id}")
    public GenreDTO getById(@PathVariable Long id) {

        return new GenreDTO(genreService.getById(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        genreService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody GenreCreationDTO dto, @PathVariable Long id) {

        Genre genre = dto.toGenre();
        genre.setId(id);

        genreService.update(genre);
    }

}
