package com.sjhs.forohub.domain.topico;

import java.time.LocalDateTime;

public record TopicoRespuestaDTO(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String curso,
        Long autorId,
        String autorNombre
) {
    public TopicoRespuestaDTO(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getCurso(),
                topico.getAutor().getId(),
                topico.getAutor().getNombre()

        );
    }
}