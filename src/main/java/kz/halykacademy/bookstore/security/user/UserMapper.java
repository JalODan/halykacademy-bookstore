package kz.halykacademy.bookstore.security.user;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "roleName", target = "role")
    User toEntity(UserCreationDTO dto);

    @Mapping(target = "roleName", source = "user.role")
    UserDTO toDTO(User user);
}
