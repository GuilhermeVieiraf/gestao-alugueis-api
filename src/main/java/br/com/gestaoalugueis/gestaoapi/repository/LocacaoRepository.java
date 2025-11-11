package br.com.gestaoalugueis.gestaoapi.repository;

import br.com.gestaoalugueis.gestaoapi.entity.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LocacaoRepository extends JpaRepository<Locacao, UUID> {
}
