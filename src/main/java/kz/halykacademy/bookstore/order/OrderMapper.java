package kz.halykacademy.bookstore.order;

import kz.halykacademy.bookstore.order.item.ItemMapper;
import kz.halykacademy.bookstore.user.UserService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserService.class, ItemMapper.class})
public interface OrderMapper {

    @Mapping(target = "user", source = "userID")
    Order toEntity(OrderCreationDTO dto);

    @Mapping(target = "userID", source = "user.id")
    OrderDTO toDTO(Order entity);
}
