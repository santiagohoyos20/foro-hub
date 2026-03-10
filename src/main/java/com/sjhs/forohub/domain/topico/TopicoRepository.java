package com.sjhs.forohub.domain.topico;

import com.sjhs.forohub.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
