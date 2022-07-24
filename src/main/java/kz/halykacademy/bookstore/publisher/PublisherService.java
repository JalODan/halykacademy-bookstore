package kz.halykacademy.bookstore.publisher;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }
    public List<Publisher> getAll() {
        return publisherRepository.findAll();
    }

    public Publisher getById(Long id) {

        if (!publisherRepository.existsById(id)) {
            throw new IllegalStateException("Publisher with ID=" + id + " not found");
        }
        return publisherRepository.findById(id).get();
    }

    public Set<Publisher> findByName(String partOfName) {

        return publisherRepository.findByNameContainingIgnoreCase(partOfName);
    }

    public void delete(Long id) {

        if (!publisherRepository.existsById(id)) {
            throw new IllegalStateException("Publisher with ID=" + id + " not found");
        }
        publisherRepository.deleteById(id);
    }

    public void create(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    public void update(Publisher publisher) {

        if (!publisherRepository.existsById(publisher.getId())) {
            throw new IllegalStateException("Publisher with ID=" + publisher.getId() + " not found");
        }

        publisherRepository.save(publisher);
    }

}
