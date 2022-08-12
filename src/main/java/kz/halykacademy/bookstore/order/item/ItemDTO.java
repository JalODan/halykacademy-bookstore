package kz.halykacademy.bookstore.order.item;

import lombok.Data;

@Data
public class ItemDTO {

    private Long id;
    private Long bookID;
    private Integer amount;
}
