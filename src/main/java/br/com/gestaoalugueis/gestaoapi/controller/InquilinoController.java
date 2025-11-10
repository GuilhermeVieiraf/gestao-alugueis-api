package br.com.gestaoalugueis.gestaoapi.controller;

import br.com.gestaoalugueis.gestaoapi.dto.InquilinoRequestDTO;
import br.com.gestaoalugueis.gestaoapi.entity.Inquilino;
import br.com.gestaoalugueis.gestaoapi.service.InquilinoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/inquilinos")
@RequiredArgsConstructor
public class InquilinoController {

    private final InquilinoService inquilinoService;

    @PostMapping
    public ResponseEntity<Inquilino> criar(@RequestBody InquilinoRequestDTO dto){
        var inquilino = inquilinoService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(inquilino);
    }

    @GetMapping
    public ResponseEntity<List<Inquilino>> listar() {
        var listarInquilinos = inquilinoService.listarInquilinos();
        return ResponseEntity.ok().body(listarInquilinos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inquilino> buscarPorId(@PathVariable UUID id){
        var buscarInquilinoId = inquilinoService.buscarInquilinoPorId(id);
        return ResponseEntity.ok().body(buscarInquilinoId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id){
        inquilinoService.deletarInquilinoPorId(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inquilino> atualizar(@PathVariable UUID id, @RequestBody InquilinoRequestDTO dto){
        var inquilinoAtualizado = inquilinoService.atualizarInquilino(id, dto);
        return ResponseEntity.ok().body(inquilinoAtualizado);
    }

}
