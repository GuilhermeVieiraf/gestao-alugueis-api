package br.com.gestaoalugueis.gestaoapi.repository;

import br.com.gestaoalugueis.gestaoapi.entity.Locacao;
import br.com.gestaoalugueis.gestaoapi.entity.Pagamento;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface PagamentoRepository extends JpaRepository<Pagamento, UUID> {

    @Transactional
    @Modifying // esta anotação indica que a query modifica os dados(DELETE/UPDATE)
    @Query("DELETE FROM Pagamento p WHERE p.locacao = :locacao AND p.statusPagamento <> 'PAGO'")
    void deleteFuturePaymentsByLocacao(@Param("locacao") Locacao locacao);

}
