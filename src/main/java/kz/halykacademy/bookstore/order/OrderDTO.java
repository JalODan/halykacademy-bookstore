package kz.halykacademy.bookstore.order;

import kz.halykacademy.bookstore.order.item.ItemDTO;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class OrderDTO {

    private Long id;
    private Long userID;
    private Set<ItemDTO> items;
    private LocalDateTime createdAt;
    private String status;
}
