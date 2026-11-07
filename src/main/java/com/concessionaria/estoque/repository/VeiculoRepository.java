package com.concessionaria.estoque.repository;

import com.concessionaria.estoque.model.StatusVeiculo;
import com.concessionaria.estoque.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.math.BigDecimal;
import java.util.List;


public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    List<Veiculo> findByMarcaId(Long marcaId);
    List<Veiculo> findByModeloId(Long modeloId);
    List<Veiculo> findByStatus(StatusVeiculo status);
    List<Veiculo> findByAnoFabricacao(Integer anoFabricacao);
    List<Veiculo> findByPrecoBetween(BigDecimal precoMin, BigDecimal precoMax);
    List<Veiculo> findByMarcaNomeIgnoreCase(String nomeMarca);
    List<Veiculo> findByModeloNomeIgnoreCase(String nomeModelo);

    @Query("""
            SELECT v FROM Veiculo v
              JOIN FETCH v.marca m
              JOIN FETCH v.modelo mo
             WHERE (:marcaId IS NULL OR m.id = :marcaId)
               AND (:modeloId IS NULL OR mo.id = :modeloId)
               AND (:precoMin IS NULL OR v.preco >= :precoMin)
               AND (:precoMax IS NULL OR v.preco <= :precoMax)
               AND (:ano IS NULL OR v.anoFabricacao = :ano)
               AND (:status IS NULL OR v.status = :status)
            """)
    List<Veiculo> buscarComFiltros(@Param("marcaId") Long marcaId,
                                   @Param("modeloId") Long modeloId,
                                   @Param("precoMin") BigDecimal precoMin,
                                   @Param("precoMax") BigDecimal precoMax,
                                   @Param("ano") Integer ano,
                                   @Param("status") StatusVeiculo status);
}