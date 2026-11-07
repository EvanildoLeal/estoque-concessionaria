package com.concessionaria.estoque.dto;

import java.math.BigDecimal;

public class VeiculoRequestDTO {
    private Long marcaId;
    private Long modeloId;
    private Integer anoFabricacao;
    private String cor;
    private BigDecimal preco;
    private Long quilometragem;
    private String status;

    public Long getMarcaId() { return marcaId; }
    public void setMarcaId(Long marcaId) { this.marcaId = marcaId; }
    public Long getModeloId() { return modeloId; }
    public void setModeloId(Long modeloId) { this.modeloId = modeloId; }
    public Integer getAnoFabricacao() { return anoFabricacao; }
    public void setAnoFabricacao(Integer anoFabricacao) { this.anoFabricacao = anoFabricacao; }
    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }
    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }
    public Long getQuilometragem() { return quilometragem; }
    public void setQuilometragem(Long quilometragem) { this.quilometragem = quilometragem; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}