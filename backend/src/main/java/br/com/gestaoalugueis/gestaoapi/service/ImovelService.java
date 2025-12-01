package br.com.gestaoalugueis.gestaoapi.service;

import br.com.gestaoalugueis.gestaoapi.dto.ImovelRequestDTO;
import br.com.gestaoalugueis.gestaoapi.entity.Imovel;
import br.com.gestaoalugueis.gestaoapi.enums.Status;
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
        Imovel newImovel = new Imovel();
        newImovel.setEndereco(dto.endereco());
        newImovel.setNumero(dto.numero());
        newImovel.setComplemento(dto.complemento());
        newImovel.setBairro(dto.bairro());
        newImovel.setCidade(dto.cidade());
        newImovel.setEstado(dto.estado());
        newImovel.setCep(dto.cep());
        newImovel.setTipoImovel(dto.tipo());
        newImovel.setStatus(Status.ATIVO); // defini o status como ativo a partir da criação

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
        Imovel imovelAtualizado = this.buscarImovelPorId(id);
        imovelAtualizado.setEndereco(dto.endereco());
        imovelAtualizado.setNumero(dto.numero());
        imovelAtualizado.setComplemento(dto.complemento());
        imovelAtualizado.setBairro(dto.bairro());
        imovelAtualizado.setCidade(dto.cidade());
        imovelAtualizado.setEstado(dto.estado());
        imovelAtualizado.setCep(dto.cep());
        imovelAtualizado.setTipoImovel(dto.tipo());

        return imovelRepository.save(imovelAtualizado);
    }

}
