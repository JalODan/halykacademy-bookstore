package kz.halykacademy.bookstore.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;
    private String name;
    private String login;
    private boolean isAdmin;

    public UserDTO(User user) {

        this.id = user.getId();
        this.name = user.getName();
        this.login = user.getLogin();
        this.isAdmin = user.isAdmin();
    }
}
