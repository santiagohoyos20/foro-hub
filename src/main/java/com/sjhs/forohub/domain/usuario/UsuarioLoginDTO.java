package com.sjhs.forohub.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record UsuarioLoginDTO(
        @NotBlank
        String email,
        @NotBlank
        String password
) {
}
