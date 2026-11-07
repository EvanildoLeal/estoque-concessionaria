package com.concessionaria.estoque.repository;

import com.concessionaria.estoque.model.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ModeloRepository extends JpaRepository<Modelo, Long> {
    List<Modelo> findByMarcaId(Long marcaId);
    Optional<Modelo> findByNomeIgnoreCaseAndMarcaId(String nome, Long marcaId);
}