package com.sjhs.forohub.controller;

import com.sjhs.forohub.domain.topico.ListarTopicosService;
import com.sjhs.forohub.domain.topico.RegistrarTopicoDTO;
import com.sjhs.forohub.domain.topico.RegistrarTopicoService;
import com.sjhs.forohub.domain.topico.TopicoRespuestaDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private RegistrarTopicoService registrarTopicoService;

    @Autowired
    private ListarTopicosService listarTopicosService;

    @GetMapping
    public ResponseEntity<Page<TopicoRespuestaDTO>> listar(@PageableDefault(size = 2) Pageable paginacion) {
        return ResponseEntity.ok(listarTopicosService.listar(paginacion));
    }

    @PostMapping
    @Transactional
    public ResponseEntity registrar(@RequestBody @Valid RegistrarTopicoDTO topico) {

        var respuesta = registrarTopicoService.registrar(topico);
        return ResponseEntity.ok(respuesta);
    }
}
