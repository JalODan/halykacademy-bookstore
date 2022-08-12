package kz.halykacademy.bookstore.order.item;

import kz.halykacademy.bookstore.book.BookService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {BookService.class})
public interface ItemMapper {

    @Mapping(target = "book", source = "bookID")
    Item toEntity(ItemCreationDTO dto);

    @Mapping(target = "bookID", source = "book.id")
    ItemDTO toDTO(Item entity);
}
