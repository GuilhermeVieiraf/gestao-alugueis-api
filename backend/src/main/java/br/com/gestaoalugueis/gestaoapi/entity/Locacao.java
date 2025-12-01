package br.com.gestaoalugueis.gestaoapi.entity;

import br.com.gestaoalugueis.gestaoapi.enums.Status;
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
@Table(name = "locacoes")
public class Locacao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valor_aluguel;
    @Column(nullable = false)
    private Integer dia_vencimento;
    @Column(nullable = false)
    private LocalDate data_inicio_contrato;
    @Column(nullable = false)
    private Integer duracao_meses;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;
    @ManyToOne   //  Muitas Locações para um imóvel
    @JoinColumn(name = "imovel_id", nullable = false)
    private Imovel imovel;
    @ManyToOne   //  Muitos locações para um inquilino
    @JoinColumn(name = "inquilino_id", nullable = false)
    private Inquilino inquilino;
}
