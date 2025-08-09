package rest_api.rest_api_sprintboot.mapper;

import rest_api.rest_api_sprintboot.dto.users.UserRequestDTO;
import rest_api.rest_api_sprintboot.dto.users.UserResponseDTO;
import rest_api.rest_api_sprintboot.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toEntity(UserRequestDTO dto);
    UserResponseDTO toDTO(User entity);
}