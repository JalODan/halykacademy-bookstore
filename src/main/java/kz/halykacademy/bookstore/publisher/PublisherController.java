package kz.halykacademy.bookstore.publisher;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/v1/publisher")
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping
    public List<PublisherDTO> getAll() {
        return publisherService.getAll().stream().map(PublisherDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PublisherDTO getById(@PathVariable Long id) {
        return new PublisherDTO(publisherService.getById(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        publisherService.delete(id);
    }

    @PostMapping
    public void create(@RequestBody PublisherCreationDTO dto) {
        Publisher publisher = dto.toPublisher();
        publisherService.create(publisher);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody PublisherCreationDTO dto) {
        Publisher publisher = dto.toPublisher();
        publisher.setId(id);
        publisherService.update(publisher);
    }

    @GetMapping("/search/{partOfName}")
    public Set<PublisherDTO> findByName(@PathVariable String partOfName) {

        return publisherService.findByName(partOfName).stream().map(PublisherDTO::new).collect(Collectors.toSet());
    }
}
