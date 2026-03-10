package com.sjhs.forohub.controller;

import com.sjhs.forohub.domain.topico.RegistrarTopicoDTO;
import com.sjhs.forohub.domain.topico.TopicoRepository;
import com.sjhs.forohub.domain.usuario.*;
import com.sjhs.forohub.infra.security.DatosJWTToken;
import com.sjhs.forohub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    @Autowired
    private RegistrarUsuarioService registrarUsuarioService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity autenticarUsuario(@RequestBody @Valid UsuarioLoginDTO datosAutenticacionUsuario) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.email(),
                datosAutenticacionUsuario.password());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTToken(JWTtoken));
    }

    @PostMapping("/registrar")
    @Transactional
    public ResponseEntity registrar(@RequestBody @Valid RegistrarUsuarioDTO datos) {

        registrarUsuarioService.registrar(datos);
        return ResponseEntity.ok().build();
    }


}
