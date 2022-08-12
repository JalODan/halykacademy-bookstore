package kz.halykacademy.bookstore.order.item;

import lombok.*;

@Data
public class ItemCreationDTO {

    private Long bookID;
    private Integer amount;
}
