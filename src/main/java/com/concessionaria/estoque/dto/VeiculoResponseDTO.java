package com.concessionaria.estoque.dto;

import java.math.BigDecimal;

public class VeiculoResponseDTO {
    private Long id;
    private Long marcaId; // NOVO
    private Long modeloId; // NOVO
    private String marca;
    private String modelo;
    private Integer anoFabricacao;
    private String cor;
    private BigDecimal preco;
    private Long quilometragem;
    private String status;

    public VeiculoResponseDTO() {}

    public VeiculoResponseDTO(Long id, Long marcaId, Long modeloId, String marca, String modelo, Integer anoFabricacao, String cor, BigDecimal preco, Long quilometragem, String status) {
        this.id = id;
        this.marcaId = marcaId;
        this.modeloId = modeloId;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.cor = cor;
        this.preco = preco;
        this.quilometragem = quilometragem;
        this.status = status;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getMarcaId() { return marcaId; }
    public void setMarcaId(Long marcaId) { this.marcaId = marcaId; }
    public Long getModeloId() { return modeloId; }
    public void setModeloId(Long modeloId) { this.modeloId = modeloId; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
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