package kz.halykacademy.bookstore.Genre;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> getAll() {

        return genreRepository.findAll();
    }

    public Genre getById(Long id) {

        if (!genreRepository.existsById(id)) {
            throw new IllegalStateException("Genre with ID=" + id + " not found");
        }

        return genreRepository.findById(id).get();
    }

    public void delete(Long id) {

        if (!genreRepository.existsById(id)) {
            throw new IllegalStateException("Genre with ID=" + id + " not found");
        }

        genreRepository.deleteById(id);
    }

    public void create(Genre genre) {
        genreRepository.save(genre);
    }

    public void update(Genre genre) {

        if (!genreRepository.existsById(genre.getId())) {
            throw new IllegalStateException("Genre with ID=" + genre.getId() + " not found");
        }

        genreRepository.save(genre);
    }
}
