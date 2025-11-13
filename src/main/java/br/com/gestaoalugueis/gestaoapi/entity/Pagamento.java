package br.com.gestaoalugueis.gestaoapi.entity;

import br.com.gestaoalugueis.gestaoapi.enums.StatusPagamento;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "pagamentos")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "locacao_id", nullable = false)
    private Locacao locacao; // uma Locação para vários pagamentos
    @Column(nullable = false)
    private LocalDate dataReferencia;
    @Column(nullable = false)
    private LocalDate dataVencimento;
    @Column(nullable = false)
    private BigDecimal valorEsperado;
    @Column(nullable = true)
    private LocalDate dataPagamento;
    @Column(nullable = true)
    private BigDecimal valorPago;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusPagamento statusPagamento;
}
