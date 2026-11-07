package com.concessionaria.estoque.dto;

public class ModeloDTO {
    private Long id;
    private String nome;
    private Long marcaId;
    private String marcaNome;

    public ModeloDTO() {}
    public ModeloDTO(Long id, String nome, Long marcaId, String marcaNome) {
        this.id = id;
        this.nome = nome;
        this.marcaId = marcaId;
        this.marcaNome = marcaNome;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Long getMarcaId() { return marcaId; }
    public void setMarcaId(Long marcaId) { this.marcaId = marcaId; }
    public String getMarcaNome() { return marcaNome; }
    public void setMarcaNome(String marcaNome) { this.marcaNome = marcaNome; }
}