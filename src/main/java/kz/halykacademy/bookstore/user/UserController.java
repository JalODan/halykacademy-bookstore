package kz.halykacademy.bookstore.user;


import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {
    
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Set<UserDTO> getAll() {
        return userService.getAll().stream().map(UserDTO::new).collect(Collectors.toSet());
    }

    @PostMapping
    public void create(@RequestBody UserCreationDTO dto) {
        User user = dto.toUser();
        userService.create(user);
    }

    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable Long id) {
        return new UserDTO(userService.getById(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody UserCreationDTO dto) {

        User user = dto.toUser();
        user.setId(id);
        userService.update(user);
    }
    
}
