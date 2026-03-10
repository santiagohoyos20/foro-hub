package com.sjhs.forohub.domain.topico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarTopicosService {
    @Autowired
    private TopicoRepository topicoRepository;

    public Page<TopicoRespuestaDTO> listar(Pageable paginacion) {
        return topicoRepository.findAll(paginacion)
                .map(TopicoRespuestaDTO::new);
    }
}
