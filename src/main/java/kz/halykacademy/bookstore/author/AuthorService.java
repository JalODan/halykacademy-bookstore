package kz.halykacademy.bookstore.author;

import kz.halykacademy.bookstore.genre.Genre;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    public Author getById(Long id) {
        if (!authorRepository.existsById(id)) {
            throw new IllegalStateException("Author with ID=" + id + " not found");
        }
        return authorRepository.findById(id).get();
    }

    public void delete(Long id) {

        if (!authorRepository.existsById(id)) {
            throw new IllegalStateException("Author with ID=" + id + " not found");
        }
        authorRepository.deleteById(id);
    }

    public void create(Author author) {
        authorRepository.save(author);
    }

    public void update(Author author) {

        if (!authorRepository.existsById(author.getId())) {
            throw new IllegalStateException("Author with ID=" + author.getId() + " not found");
        }

        authorRepository.save(author);
    }

    public Set<Author> findByName(String partOfName) {

        return authorRepository.getAuthorsByFirstnameContainingIgnoreCaseOrLastnameContainingIgnoreCaseOrFathernameContainingIgnoreCase(partOfName, partOfName, partOfName);
    }


    public List<Author> findByGenres(Set<Genre> genres) {

        return authorRepository.findByGenres(genres);
    }
}
