package br.com.gestaoalugueis.gestaoapi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record PagamentoBaixaDTO(
        UUID pagamentoId,
        BigDecimal valorPago,
        LocalDate dataPagamento
) {
}
