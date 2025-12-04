package br.com.gestaoalugueis.gestaoapi.repository;

import br.com.gestaoalugueis.gestaoapi.entity.Locacao;
import br.com.gestaoalugueis.gestaoapi.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface LocacaoRepository extends JpaRepository<Locacao, UUID> {

    // verifica se existe uma locação ativa para o Imóvel especificado
    Optional<Locacao> findByImovelIdAndStatus(UUID imovelId, Status status);

}
