package rest_api.rest_api_sprintboot.dto.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequestDTO(
        @NotBlank(message = "El nombre es obligatorio")
        String name,

        @Email(message = "El email debe tener un formato válido")
        String email
) {}