package br.com.gestaoalugueis.gestaoapi.service;

import br.com.gestaoalugueis.gestaoapi.dto.PagamentoBaixaDTO;
import br.com.gestaoalugueis.gestaoapi.entity.Pagamento;
import br.com.gestaoalugueis.gestaoapi.enums.StatusPagamento;
import br.com.gestaoalugueis.gestaoapi.repository.PagamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;

    public Pagamento darBaixa(UUID pagamentoId, PagamentoBaixaDTO dto) {
        Pagamento pagamento = pagamentoRepository.findById(pagamentoId)
                .orElseThrow(() -> new RuntimeException("Pagamento nõo encontrado"));

        if (pagamento.getStatusPagamento() == StatusPagamento.PAGO) {
            throw new RuntimeException("Esta parcela já foi paga.");
        }
        pagamento.setDataPagamento(dto.dataPagamento());
        pagamento.setValorPago(dto.valorPago());
        pagamento.setStatusPagamento(StatusPagamento.PAGO);

        return pagamentoRepository.save(pagamento);
    }
}
