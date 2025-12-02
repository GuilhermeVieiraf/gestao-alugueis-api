package br.com.gestaoalugueis.gestaoapi.repository;

import br.com.gestaoalugueis.gestaoapi.entity.Locacao;
import br.com.gestaoalugueis.gestaoapi.entity.Pagamento;
import br.com.gestaoalugueis.gestaoapi.enums.StatusPagamento;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface PagamentoRepository extends JpaRepository<Pagamento, UUID> {

    List<Pagamento> findByStatusPagamentoAndDataVencimentoLessThanEqual(
            StatusPagamento status,
            LocalDate dataLimete
    );

    @Transactional
    @Modifying // esta anotação indica que a query modifica os dados(DELETE/UPDATE)
    @Query("DELETE FROM Pagamento p WHERE p.locacao = :locacao AND p.statusPagamento <> 'PAGO'")
    void deleteFuturePaymentsByLocacao(@Param("locacao") Locacao locacao);

    @Transactional
    @Modifying
    @Query("UPDATE Pagamento p SET p.valorEsperado = :novoValor " +
            "WHERE p.locacao.id = :locacaoId AND p.statusPagamento <> 'PAGO'")
    void updateFutureExpectedValue(  // atualiza o valor esperado em lote para todas as parcelas futuras e não pagas de uma locação
            @Param("locacaoId") UUID locacaoId,
            @Param("novoValor") BigDecimal novoValor
    );

}
