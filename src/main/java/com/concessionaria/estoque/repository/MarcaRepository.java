package com.concessionaria.estoque.repository;

import com.concessionaria.estoque.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
    Optional<Marca> findByNomeIgnoreCase(String nome);
    boolean existsByNomeIgnoreCase(String nome);
}