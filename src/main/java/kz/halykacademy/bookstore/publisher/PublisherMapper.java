package kz.halykacademy.bookstore.publisher;

import kz.halykacademy.bookstore.book.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PublisherMapper {

    Publisher toEntity(PublisherCreationDTO dto);

    @Mapping(target = "bookIDs", source = "books")
    PublisherDTO toDto(Publisher publisher);

    List<Long> bookIDs(List<Book> books);

    default Long toId(Book book) {
        return book.getId();
    }
}
