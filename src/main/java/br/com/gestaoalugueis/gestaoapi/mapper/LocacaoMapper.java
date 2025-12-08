package br.com.gestaoalugueis.gestaoapi.mapper;

import br.com.gestaoalugueis.gestaoapi.dto.LocacaoRequestDTO;
import br.com.gestaoalugueis.gestaoapi.entity.Locacao;
import br.com.gestaoalugueis.gestaoapi.enums.Status;

public final class LocacaoMapper {

    private LocacaoMapper(){};

    public static Locacao toEntity(LocacaoRequestDTO dto) {
        Locacao locacao = new Locacao();
        locacao.setValor_aluguel(dto.valor_aluguel());
        locacao.setDia_vencimento(dto.dia_vencimento());
        locacao.setData_inicio_contrato(dto.data_inicio_contrato());
        locacao.setDuracao_meses(dto.duracao_meses());
        locacao.setStatus(Status.ATIVO);

        return locacao;

    }

}
