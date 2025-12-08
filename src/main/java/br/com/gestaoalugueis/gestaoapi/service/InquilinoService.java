package br.com.gestaoalugueis.gestaoapi.service;

import br.com.gestaoalugueis.gestaoapi.dto.InquilinoRequestDTO;
import br.com.gestaoalugueis.gestaoapi.entity.Inquilino;
import br.com.gestaoalugueis.gestaoapi.enums.Status;
import br.com.gestaoalugueis.gestaoapi.mapper.InquilinoMapper;
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
        Inquilino newInquilino = InquilinoMapper.toEntity(dto);
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
        Inquilino inquilinoAntigo = inquilinoRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Inquilino não encontrado."));

        Inquilino inquilinoAtualizado = InquilinoMapper.toEntity(dto);
        inquilinoAtualizado.setId(inquilinoAntigo.getId());

        return inquilinoRepository.save(inquilinoAtualizado);
    }

    public void deletarInquilinoPorId(UUID id) {
        Inquilino inquilinoInativo = buscarInquilinoPorId(id);
        inquilinoInativo.setStatus(Status.INATIVO);
        inquilinoRepository.save(inquilinoInativo);
    }

}
