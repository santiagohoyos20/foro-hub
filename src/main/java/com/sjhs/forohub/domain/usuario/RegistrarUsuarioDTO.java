package com.sjhs.forohub.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record RegistrarUsuarioDTO(
        @NotBlank
        String nombre,
        @NotBlank
        String email,
        @NotBlank
        String password
) {
}
