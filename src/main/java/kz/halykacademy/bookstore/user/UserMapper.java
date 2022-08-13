package kz.halykacademy.bookstore.user;

import kz.halykacademy.bookstore.security.EncodedMapping;
import kz.halykacademy.bookstore.security.PasswordEncoderMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {PasswordEncoderMapper.class})
public interface UserMapper {

    @Mapping(source = "roleName", target = "role")
    @Mapping(target = "password", qualifiedBy = EncodedMapping.class)
    User toEntity(UserCreationDTO dto);

    @Mapping(target = "roleName", source = "user.role")
    UserDTO toDTO(User user);

}
