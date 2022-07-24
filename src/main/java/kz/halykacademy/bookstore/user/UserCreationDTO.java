package kz.halykacademy.bookstore.user;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserCreationDTO {

    private String name;
    private String login;
    private String password;
    private Boolean isAdmin;

    public User toUser() {

        return User.builder()
                .name(name)
                .login(login)
                .password(password)
                .isAdmin(isAdmin)
                .build();
    }
}
