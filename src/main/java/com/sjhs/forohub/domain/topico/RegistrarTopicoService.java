package com.sjhs.forohub.domain.topico;

import com.sjhs.forohub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class RegistrarTopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public TopicoRespuestaDTO registrar(RegistrarTopicoDTO datosNuevoTopico) {
        var usuario = usuarioRepository.findById(datosNuevoTopico.idUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (topicoRepository.existsByTituloOrMensaje(datosNuevoTopico.titulo(), datosNuevoTopico.mensaje())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Este tópico ya existe"
            );
        }
        var topico = new Topico(datosNuevoTopico, usuario);
        topicoRepository.save(topico);
        return new TopicoRespuestaDTO(topico);
    }
}
