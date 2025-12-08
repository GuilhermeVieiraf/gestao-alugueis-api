package br.com.gestaoalugueis.gestaoapi.mapper;

import br.com.gestaoalugueis.gestaoapi.dto.ImovelRequestDTO;
import br.com.gestaoalugueis.gestaoapi.entity.Imovel;
import br.com.gestaoalugueis.gestaoapi.enums.Status;

public final class ImovelMapper {

    private ImovelMapper() {}

    public static Imovel toEntity(ImovelRequestDTO dto) {
        Imovel imovel = new Imovel();

        imovel.setEndereco(dto.endereco());
        imovel.setNumero(dto.numero());
        imovel.setComplemento(dto.complemento());
        imovel.setBairro(dto.bairro());
        imovel.setCidade(dto.cidade());
        imovel.setEstado(dto.estado());
        imovel.setCep(dto.cep());
        imovel.setTipoImovel(dto.tipo());
        imovel.setStatus(Status.ATIVO); // defini o status como ativo a partir da criação

        return imovel;
    }

}
