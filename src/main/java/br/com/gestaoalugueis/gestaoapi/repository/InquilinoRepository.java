package br.com.gestaoalugueis.gestaoapi.repository;

import br.com.gestaoalugueis.gestaoapi.entity.Inquilino;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InquilinoRepository extends JpaRepository<Inquilino, UUID> {
}
