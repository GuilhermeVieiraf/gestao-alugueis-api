package br.com.gestaoalugueis.gestaoapi.service;

import br.com.gestaoalugueis.gestaoapi.dto.LocacaoRequestDTO;
import br.com.gestaoalugueis.gestaoapi.entity.Locacao;
import br.com.gestaoalugueis.gestaoapi.enums.Status;
import br.com.gestaoalugueis.gestaoapi.repository.ImovelRepository;
import br.com.gestaoalugueis.gestaoapi.repository.InquilinoRepository;
import br.com.gestaoalugueis.gestaoapi.repository.LocacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class LocacaoService {

    private final LocacaoRepository locacaoRepository;
    private final InquilinoRepository inquilinoRepository;
    private final ImovelRepository imovelRepository;

    public Locacao criarLocacao(LocacaoRequestDTO dto) {
        var inquilinoDaLocacao = inquilinoRepository.findById(dto.inquilinoId())
                .orElseThrow(() -> new RuntimeException("Inquilino não encontrado."));
        var imovelDaLocacao = imovelRepository.findById(dto.imovelId())
                .orElseThrow(() -> new RuntimeException("Imovel não encontrado."));

        Locacao newLocacao = new Locacao();
        newLocacao.setValor_aluguel(dto.valor_aluguel());
        newLocacao.setDia_vencimento(dto.dia_vencimento());
        newLocacao.setData_inicio_contrato(dto.data_inico_contrato());
        newLocacao.setDuracao_meses(dto.duracao_meses());
        newLocacao.setStatus(Status.ATIVO);
        newLocacao.setImovel(imovelDaLocacao);
        newLocacao.setInquilino(inquilinoDaLocacao);

        return locacaoRepository.save(newLocacao);
    }

    public List<Locacao> listarLocacao() {
        return locacaoRepository.findAll();
    }

    public Locacao buscarLocacaoPorId(UUID id) {
        return locacaoRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Locação não econtrada."));
    }
}
