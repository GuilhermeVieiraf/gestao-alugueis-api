package br.com.gestaoalugueis.gestaoapi.controller;

import br.com.gestaoalugueis.gestaoapi.dto.PagamentoBaixaDTO;
import br.com.gestaoalugueis.gestaoapi.entity.Pagamento;
import br.com.gestaoalugueis.gestaoapi.service.PagamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/pagamentos")
@RequiredArgsConstructor
public class PagamentoController {

    private final PagamentoService pagamentoService;

    @PatchMapping("/{id}/baixa")
    public ResponseEntity<Pagamento> darBaixa(@PathVariable UUID id,
                                              @RequestBody PagamentoBaixaDTO dto) {

        var baixaPagamento = pagamentoService.darBaixa(id, dto);
        return ResponseEntity.ok(baixaPagamento);
    }

    // rota manual para verificar e atualizar parcelas vencidas.
    @PostMapping("/validar-vencimentos")
    public ResponseEntity<String> validarVencimentos() {
        int atualizados = pagamentoService.validarVencimentos();
        if (atualizados > 0) {
            return ResponseEntity.ok("Processo de validação concluído. " + atualizados + " parcelas foram atualizadas para 'ATRASADO'. ");
        } else {
            return ResponseEntity.ok("Processo de validação concluído. Nenhuma parcela precisou ser atualizada.");
        }
    }

}
