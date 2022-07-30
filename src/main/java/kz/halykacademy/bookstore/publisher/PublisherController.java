package kz.halykacademy.bookstore.publisher;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/v1/publisher")
public class PublisherController {

    private final PublisherService publisherService;
    private final PublisherMapper publisherMapper;

    public PublisherController(PublisherService publisherService , PublisherMapper publisherMapper) {
        this.publisherService = publisherService;
         this.publisherMapper = publisherMapper;
    }

    @GetMapping
    public List<PublisherDTO> getAll() {
        return publisherService.getAll().stream().map(publisherMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PublisherDTO getById(@PathVariable Long id) {

        Publisher publisher = publisherService.getById(id);
        return publisherMapper.toDto(publisher);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        publisherService.delete(id);
    }

    @PostMapping
    public void create(@RequestBody PublisherCreationDTO dto) {
        publisherService.create(publisherMapper.toEntity(dto));
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody PublisherCreationDTO dto) {
        Publisher publisher = publisherMapper.toEntity(dto);
        publisher.setId(id);
        publisherService.update(publisher);
    }

    @GetMapping("/search/{partOfName}")
    public Set<PublisherDTO> findByName(@PathVariable String partOfName) {
        return publisherService.findByName(partOfName).stream().map(publisherMapper::toDto).collect(Collectors.toSet());
    }
}
