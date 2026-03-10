package com.sjhs.forohub.domain.topico;

import com.sjhs.forohub.domain.usuario.Usuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegistrarTopicoDTO(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        @Valid
        Long idUsuario,
        @NotBlank
        String curso
) {
}
