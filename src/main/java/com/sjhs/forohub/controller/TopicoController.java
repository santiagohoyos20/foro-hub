package com.sjhs.forohub.controller;

import com.sjhs.forohub.domain.topico.*;
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
    private TopicoService topicoService;

    @GetMapping
    public ResponseEntity<Page<TopicoRespuestaDTO>> listar(@PageableDefault(size = 2) Pageable paginacion) {
        return ResponseEntity.ok(topicoService.listar(paginacion));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicoRespuestaDTO> listarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(topicoService.listarPorId(id));
    }

    @PostMapping
    public ResponseEntity<TopicoRespuestaDTO> registrar(@RequestBody @Valid RegistrarTopicoDTO topico) {
        var respuesta = registrarTopicoService.registrar(topico);
        return ResponseEntity.ok(respuesta);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicoRespuestaDTO> actualizarTopico(@PathVariable Long id, @RequestBody @Valid ActualizarTopicoDTO datosActualizarTopico) {
        TopicoRespuestaDTO topico = topicoService.actualizarTopico(id, datosActualizarTopico);
        return ResponseEntity.ok(topico);
    }

    // DELETE LOGICO
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarMedico(@PathVariable Long id) {
        topicoService.eliminarTopico(id);
        return ResponseEntity.noContent().build();
    }
}
