package br.com.gestaoalugueis.gestaoapi.mapper;

import br.com.gestaoalugueis.gestaoapi.dto.InquilinoRequestDTO;
import br.com.gestaoalugueis.gestaoapi.entity.Inquilino;
import br.com.gestaoalugueis.gestaoapi.enums.Status;

public final class InquilinoMapper {

    private InquilinoMapper() {}

    public static Inquilino toEntity(InquilinoRequestDTO dto) {
        Inquilino inquilino = new Inquilino();
        inquilino.setNome(dto.nome());
        inquilino.setCpf(dto.cpf());
        inquilino.setTelefone(dto.telefone());
        inquilino.setEmail(dto.email());
        inquilino.setStatus(Status.ATIVO);

        return inquilino;
    }

}
