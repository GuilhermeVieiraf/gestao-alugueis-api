package br.com.gestaoalugueis.gestaoapi.service;

import br.com.gestaoalugueis.gestaoapi.dto.ImovelRequestDTO;
import br.com.gestaoalugueis.gestaoapi.entity.Imovel;
import br.com.gestaoalugueis.gestaoapi.enums.Status;
import br.com.gestaoalugueis.gestaoapi.mapper.ImovelMapper;
import br.com.gestaoalugueis.gestaoapi.repository.ImovelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ImovelService {

    private final ImovelRepository imovelRepository;

    public Imovel criar(ImovelRequestDTO dto) {
        Imovel newImovel = ImovelMapper.toEntity(dto);
        return imovelRepository.save(newImovel);
    }

    public List<Imovel> listarImoveis() {
        return imovelRepository.findAll();
    }

    public Imovel buscarImovelPorId(UUID id) {
        return imovelRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Imóvel não encontrado."));
    }

    public void deletar(UUID id) {
        Imovel imovelInativo = this.buscarImovelPorId(id);  // Como não deletamos no sentido de apagar
        imovelInativo.setStatus(Status.INATIVO);            // o histórico, apenas mudamos o status
        imovelRepository.save(imovelInativo);               // para inativo.
    }

    public Imovel atualizar(UUID id, ImovelRequestDTO dto) {
        Imovel imovelAntigo = imovelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Imóvel não encontrado."));

        Imovel imovelAtualizado = ImovelMapper.toEntity(dto);
        imovelAtualizado.setId(imovelAntigo.getId());

        return imovelRepository.save(imovelAtualizado);
    }

}
