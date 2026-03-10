package com.sjhs.forohub.controller;

import com.sjhs.forohub.domain.topico.RegistrarTopicoDTO;
import com.sjhs.forohub.domain.topico.RegistrarTopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private RegistrarTopicoService registrarTopicoService;

    @GetMapping
    public String helloWorld() {
        return "Hello world from Europe!";
    }

    @PostMapping
    @Transactional
    public ResponseEntity registrar(@RequestBody @Valid RegistrarTopicoDTO topico) {

        var respuesta = registrarTopicoService.registrar(topico);
        return ResponseEntity.ok(respuesta);
    }
}
