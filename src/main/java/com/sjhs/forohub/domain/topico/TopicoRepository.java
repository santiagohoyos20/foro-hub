package com.sjhs.forohub.domain.topico;

import com.sjhs.forohub.domain.usuario.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Optional<Topico> findById(Long id);
    boolean existsByTituloOrMensaje(String titulo, String mensaje);
    Page<Topico> findAllByStatusTrue(Pageable paginacion);
}
