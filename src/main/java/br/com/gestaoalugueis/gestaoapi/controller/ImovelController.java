package br.com.gestaoalugueis.gestaoapi.controller;

import br.com.gestaoalugueis.gestaoapi.dto.ImovelRequestDTO;
import br.com.gestaoalugueis.gestaoapi.entity.Imovel;
import br.com.gestaoalugueis.gestaoapi.service.ImovelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/imoveis")
@RequiredArgsConstructor
public class ImovelController {

    private final ImovelService imovelService;

    @PostMapping
    public ResponseEntity<Imovel> criar(@RequestBody ImovelRequestDTO dto) {
        var imovelCriado = imovelService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(imovelCriado);
    }

    @GetMapping
    public ResponseEntity<List<Imovel>> listar() {
       var listarImoveis = imovelService.listarImoveis();
       return ResponseEntity.ok().body(listarImoveis);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Imovel> buscarPorId(@PathVariable UUID id){
        var buscarImovelId = imovelService.buscarImovelPorId(id);
        return ResponseEntity.ok().body(buscarImovelId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        imovelService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Imovel> atualizar(@PathVariable UUID id, @RequestBody ImovelRequestDTO dto) {
        var imovelAtualizado = imovelService.atualizar(id, dto);
        return ResponseEntity.ok(imovelAtualizado);
    }

}
