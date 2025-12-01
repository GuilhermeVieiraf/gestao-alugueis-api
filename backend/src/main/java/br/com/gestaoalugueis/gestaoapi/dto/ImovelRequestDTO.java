package br.com.gestaoalugueis.gestaoapi.dto;

import br.com.gestaoalugueis.gestaoapi.enums.TipoImovel;

public record ImovelRequestDTO(
        String endereco,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String estado,
        String cep,
        TipoImovel tipo
) {
}
