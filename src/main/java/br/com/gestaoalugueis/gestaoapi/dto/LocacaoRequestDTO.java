package br.com.gestaoalugueis.gestaoapi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record LocacaoRequestDTO(
        BigDecimal valor_aluguel,
        Integer dia_vencimento,
        LocalDate data_inicio_contrato,
        Integer duracao_meses,
        //IDs das entidades que já existem
        UUID imovelId,
        UUID inquilinoId
) {
}
