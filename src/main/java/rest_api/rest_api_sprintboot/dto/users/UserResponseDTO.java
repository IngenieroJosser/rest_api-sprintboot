package rest_api.rest_api_sprintboot.dto.users;

public record UserResponseDTO(
        Long id,
        String name,
        String email
) {}