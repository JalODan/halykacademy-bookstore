package kz.halykacademy.bookstore.order;

import kz.halykacademy.bookstore.order.item.ItemCreationDTO;
import lombok.*;

import java.util.List;
import java.util.Set;

@Data
public class OrderCreationDTO {

    private Long userID;
    private Set<ItemCreationDTO> items;
}
