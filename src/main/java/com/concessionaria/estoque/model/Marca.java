package com.concessionaria.estoque.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "marca", uniqueConstraints = @UniqueConstraint(name = "uk_marca_nome", columnNames = "nome"))
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 80)
    private String nome;

    @OneToMany(mappedBy = "marca", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Modelo> modelos = new ArrayList<>();

    public Marca() {
    }

    public Marca(Long id, String nome) {
        this.id = id;
        this.nome = nome;
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

    public List<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Marca)) return false;
        Marca marca = (Marca) o;
        return Objects.equals(id, marca.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}