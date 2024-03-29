package kz.halykacademy.bookstore.user;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/v1/user")
public class    UserController {
    
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('user:read')")
    public Set<UserDTO> getAll() {
        return userService.getAll().stream().map(userMapper::toDTO).collect(Collectors.toSet());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('user:create')")
    public void create(@RequestBody UserCreationDTO dto) {

        User user = userMapper.toEntity(dto);
        userService.create(userMapper.toEntity(dto));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('user:read')")
    public UserDTO getById(@PathVariable Long id) {
        return userMapper.toDTO(userService.getById(id));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('user:delete')")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('user:update')")
    public void update(@PathVariable Long id, @RequestBody UserCreationDTO dto) {

        User user = userMapper.toEntity(dto);
        user.setId(id);
        userService.update(user);
    }
    
}
