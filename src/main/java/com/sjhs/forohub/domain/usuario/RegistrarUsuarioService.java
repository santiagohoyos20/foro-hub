package com.sjhs.forohub.domain.usuario;

import com.sjhs.forohub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrarUsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registrar(RegistrarUsuarioDTO datos){

        var usuario = new Usuario(
                null,
                datos.nombre(),
                datos.email(),
                passwordEncoder.encode(datos.password()),
                null
        );
        usuarioRepository.save(usuario);
    }
}
