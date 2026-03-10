package com.sjhs.forohub.domain.topico;

import com.sjhs.forohub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrarTopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public TopicoRespuestaDTO registrar (RegistrarTopicoDTO datos){
        var usuario = usuarioRepository.findById(datos.idUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        var topico = new Topico(datos, usuario);
        topicoRepository.save(topico);
        return new TopicoRespuestaDTO(topico);
    }
}
