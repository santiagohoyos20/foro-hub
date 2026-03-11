package com.sjhs.forohub.domain.topico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepository;

    public Page<TopicoRespuestaDTO> listar(Pageable paginacion) {
        return topicoRepository.findAllByStatusTrue(paginacion)
                .map(TopicoRespuestaDTO::new);
    }

    public TopicoRespuestaDTO listarPorId(Long id) {
        var topico = topicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Topico no encontrado"));
        return new TopicoRespuestaDTO(topico);
    }

    public TopicoRespuestaDTO actualizarTopico(Long id, ActualizarTopicoDTO datosActualizarTopico) {
        Topico topico = topicoRepository.getReferenceById(id);
        topico.actualizarDatos(datosActualizarTopico);
        return new TopicoRespuestaDTO(topico);
    }

    public void eliminarTopico(Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topico.desactivar();
    }
}
