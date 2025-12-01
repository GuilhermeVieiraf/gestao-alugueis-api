package br.com.gestaoalugueis.gestaoapi.controller;

import br.com.gestaoalugueis.gestaoapi.dto.LocacaoRequestDTO;
import br.com.gestaoalugueis.gestaoapi.entity.Locacao;
import br.com.gestaoalugueis.gestaoapi.service.LocacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/locacoes")
@RequiredArgsConstructor
public class LocacaoController {

    private final LocacaoService locacaoService;

    @PostMapping
    public ResponseEntity<Locacao> criarLocacao(@RequestBody LocacaoRequestDTO dto) {
        var locacaoCriada = locacaoService.criarLocacao(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(locacaoCriada);
    }

    @GetMapping
    public ResponseEntity<List<Locacao>> listarLocacoes() {
        var listarLocacoes = locacaoService.listarLocacao();
        return ResponseEntity.ok().body(listarLocacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Locacao> buscarPorId(@PathVariable UUID id) {
        var buscarLocacaoId = locacaoService.buscarLocacaoPorId(id);
        return ResponseEntity.ok().body(buscarLocacaoId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Locacao> atualizarLocacao(@PathVariable UUID id, @RequestBody LocacaoRequestDTO dto) {
        var locacaoAtualizada = locacaoService.atualizarLocacao(id, dto);
        return ResponseEntity.ok().body(locacaoAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        locacaoService.deletarLocacaoPorId(id);
        return ResponseEntity.noContent().build();
    }


}
