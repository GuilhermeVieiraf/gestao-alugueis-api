package br.com.gestaoalugueis.gestaoapi.repository;

import br.com.gestaoalugueis.gestaoapi.entity.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ImovelRepository extends JpaRepository<Imovel, UUID> {
}
