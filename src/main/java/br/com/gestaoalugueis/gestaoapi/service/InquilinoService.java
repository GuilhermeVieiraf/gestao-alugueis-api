package br.com.gestaoalugueis.gestaoapi.service;

import br.com.gestaoalugueis.gestaoapi.dto.InquilinoRequestDTO;
import br.com.gestaoalugueis.gestaoapi.entity.Inquilino;
import br.com.gestaoalugueis.gestaoapi.enums.Status;
import br.com.gestaoalugueis.gestaoapi.repository.InquilinoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class InquilinoService {
    private final InquilinoRepository inquilinoRepository;

    public Inquilino criar(InquilinoRequestDTO dto) {
        Inquilino newInquilino = new Inquilino();
        newInquilino.setNome(dto.nome());
        newInquilino.setCpf(dto.cpf());
        newInquilino.setTelefone(dto.telefone());
        newInquilino.setEmail(dto.email());
        newInquilino.setStatus(Status.ATIVO);

        return inquilinoRepository.save(newInquilino);
    }

    public List<Inquilino> listarInquilinos() {
        return inquilinoRepository.findAll();
    }

    public Inquilino buscarInquilinoPorId(UUID id) {
        return inquilinoRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Inquilino não encontrado."));
    }

    public Inquilino atualizarInquilino(UUID id, InquilinoRequestDTO dto) {
        Inquilino inquilinoAtualizado = buscarInquilinoPorId(id);
        inquilinoAtualizado.setNome(dto.nome());
        inquilinoAtualizado.setCpf(dto.cpf());
        inquilinoAtualizado.setTelefone(dto.telefone());
        inquilinoAtualizado.setEmail(dto.email());

        return inquilinoRepository.save(inquilinoAtualizado);
    }

    public void deletarInquilinoPorId(UUID id) {
        Inquilino inquilinoInativo = buscarInquilinoPorId(id);
        inquilinoInativo.setStatus(Status.INATIVO);
        inquilinoRepository.save(inquilinoInativo);
    }

}
