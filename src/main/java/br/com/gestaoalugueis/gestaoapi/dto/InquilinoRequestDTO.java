package br.com.gestaoalugueis.gestaoapi.dto;

public record InquilinoRequestDTO(
        String nome,
        String cpf,
        String telefone,
        String email
) {
}
