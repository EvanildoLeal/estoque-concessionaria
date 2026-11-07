package com.concessionaria.estoque.service;

import com.concessionaria.estoque.dto.VeiculoRequestDTO;
import com.concessionaria.estoque.dto.VeiculoResponseDTO;
import com.concessionaria.estoque.exception.RecursoNaoEncontradoException;
import com.concessionaria.estoque.model.Marca;
import com.concessionaria.estoque.model.Modelo;
import com.concessionaria.estoque.model.StatusVeiculo;
import com.concessionaria.estoque.model.Veiculo;
import com.concessionaria.estoque.repository.MarcaRepository;
import com.concessionaria.estoque.repository.ModeloRepository;
import com.concessionaria.estoque.repository.VeiculoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final MarcaRepository marcaRepository;
    private final ModeloRepository modeloRepository;

    public VeiculoService(VeiculoRepository veiculoRepository,
                          MarcaRepository marcaRepository,
                          ModeloRepository modeloRepository) {
        this.veiculoRepository = veiculoRepository;
        this.marcaRepository = marcaRepository;
        this.modeloRepository = modeloRepository;
    }

    @Transactional
    public VeiculoResponseDTO cadastrar(VeiculoRequestDTO dto) {
        Marca marca = marcaRepository.findById(dto.getMarcaId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Marca não encontrada para o id: " + dto.getMarcaId()));

        Modelo modelo = modeloRepository.findById(dto.getModeloId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Modelo não encontrado para o id: " + dto.getModeloId()));

        if (!modelo.getMarca().getId().equals(marca.getId())) {
            throw new IllegalArgumentException("O modelo informado não pertence à marca informada.");
        }

        StatusVeiculo status = parseStatus(dto.getStatus());

        Veiculo veiculo = new Veiculo(null, modelo, marca, dto.getAnoFabricacao(), dto.getCor(), dto.getPreco(), dto.getQuilometragem(), status);

        Veiculo salvo = veiculoRepository.save(veiculo);
        return toResponseDTO(salvo);
    }

    @Transactional(readOnly = true)
    public List<VeiculoResponseDTO> listarComFiltros(Long marcaId, Long modeloId, BigDecimal precoMin, BigDecimal precoMax, Integer ano, String status) {
        StatusVeiculo statusEnum = (status == null || status.isBlank()) ? null : parseStatus(status);
        return veiculoRepository.buscarComFiltros(marcaId, modeloId, precoMin, precoMax, ano, statusEnum)
                .stream().map(this::toResponseDTO).toList();
    }

    @Transactional(readOnly = true)
    public VeiculoResponseDTO buscarPorId(Long id) {
        Veiculo veiculo = veiculoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Veículo não encontrado para o id: " + id));
        return toResponseDTO(veiculo);
    }

    @Transactional
    public VeiculoResponseDTO atualizar(Long id, VeiculoRequestDTO dto) {
        Veiculo veiculo = veiculoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Veículo não encontrado para o id: " + id));

        Marca marca = marcaRepository.findById(dto.getMarcaId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Marca não encontrada para o id: " + dto.getMarcaId()));

        Modelo modelo = modeloRepository.findById(dto.getModeloId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Modelo não encontrado para o id: " + dto.getModeloId()));

        if (!modelo.getMarca().getId().equals(marca.getId())) {
            throw new IllegalArgumentException("O modelo informado não pertence à marca informada.");
        }

        StatusVeiculo status = parseStatus(dto.getStatus());

        veiculo.setMarca(marca);
        veiculo.setModelo(modelo);
        veiculo.setAnoFabricacao(dto.getAnoFabricacao());
        veiculo.setCor(dto.getCor());
        veiculo.setPreco(dto.getPreco());
        veiculo.setQuilometragem(dto.getQuilometragem());
        veiculo.setStatus(status);

        Veiculo atualizado = veiculoRepository.save(veiculo);
        return toResponseDTO(atualizado);
    }

    @Transactional
    public void remover(Long id) {
        Veiculo veiculo = veiculoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Veículo não encontrado para o id: " + id));
        veiculoRepository.delete(veiculo);
    }

    private StatusVeiculo parseStatus(String status) {
        try {
            return StatusVeiculo.valueOf(status.toUpperCase());
        } catch (IllegalArgumentException | NullPointerException ex) {
            throw new IllegalArgumentException("Status inválido. Valores permitidos: DISPONIVEL, RESERVADO, VENDIDO.");
        }
    }

    private VeiculoResponseDTO toResponseDTO(Veiculo veiculo) {
        return new VeiculoResponseDTO(
             veiculo.getId(),
                veiculo.getMarca().getId(),   // NOVO
                veiculo.getModelo().getId(),  // NOVO
                veiculo.getMarca().getNome(),
                veiculo.getModelo().getNome(),
                veiculo.getAnoFabricacao(),
                veiculo.getCor(),
                veiculo.getPreco(),
                veiculo.getQuilometragem(),
                veiculo.getStatus().name()   
        );
    }
}