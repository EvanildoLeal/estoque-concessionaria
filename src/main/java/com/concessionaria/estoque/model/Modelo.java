package com.concessionaria.estoque.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "modelo")
public class Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 80)
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "marca_id", nullable = false, foreignKey = @ForeignKey(name = "fk_modelo_marca"))
    private Marca marca;

    @OneToMany(mappedBy = "modelo", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Veiculo> veiculos = new ArrayList<>();

    public Modelo() {
    }

    public Modelo(Long id, String nome, Marca marca) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Modelo)) return false;
        Modelo modelo = (Modelo) o;
        return Objects.equals(id, modelo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}