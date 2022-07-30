package kz.halykacademy.bookstore.user;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserCreationDTO {

    private String login;
    private String password;
    private String roleName;
}
