package br.com.gestaoalugueis.gestaoapi.entity;

import br.com.gestaoalugueis.gestaoapi.enums.Status;
import br.com.gestaoalugueis.gestaoapi.enums.TipoImovel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "imoveis")
public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String endereco;
    @Column(nullable = false)
    private String numero;
    @Column(nullable = true)
    private String complemento; // complemento é o unico que não é obrigatório
    @Column(nullable = false)
    private String bairro;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String estado;
    @Column(nullable = false)
    private String cep;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoImovel tipoImovel; // Ex: casa, apartamento, comercial...
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status; // Ex: ativo ou inativo(Inativo é quando o imovel deixa de ser alugado)

}
