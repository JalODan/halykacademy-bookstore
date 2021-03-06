package kz.halykacademy.bookstore.book;

import kz.halykacademy.bookstore.genre.Genre;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Book getById(Long id) {

        if (!bookRepository.existsById(id)) {
            throw new IllegalStateException("Book with ID=" + id + " not found");
        }

        return bookRepository.findById(id).get();
    }

    public void delete(Long id) {

        if (!bookRepository.existsById(id)) {
            throw new IllegalStateException("Book with ID=" + id + " not found");
        }

        bookRepository.deleteById(id);
    }

    public void create(Book book) {

        bookRepository.save(book);
    }

    public void update(Book book) {

        if (!bookRepository.existsById(book.getId())) {
            throw new IllegalStateException("Book with ID=" + book.getId() + " not found");
        }

        bookRepository.save(book);
    }

    public Set<Book> findByTitle(String partOfTitle) {
        return bookRepository.findByTitleContainingIgnoreCase(partOfTitle);
    }

    public List<Book> findByGenres(Set<Genre> genres) {

        return bookRepository.findByGenres(genres);
    }
}
