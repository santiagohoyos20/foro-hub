package com.sjhs.forohub.domain.topico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ActualizarTopicoDTO(
        String titulo,
        String mensaje,
        Boolean status
) {
}
