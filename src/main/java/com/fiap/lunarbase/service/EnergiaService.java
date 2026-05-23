package com.fiap.lunarbase.service;

import com.fiap.lunarbase.model.ConsumoEnergia;
import com.fiap.lunarbase.repository.EnergiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EnergiaService {

    @Autowired
    private EnergiaRepository energiaRepository;

    public List<ConsumoEnergia> listarTodos() {
        return energiaRepository.findAll();
    }

    public Optional<ConsumoEnergia> buscarPorId(Long id) {
        return energiaRepository.findById(id);
    }

    public ConsumoEnergia salvar(ConsumoEnergia consumo) {
        return energiaRepository.save(consumo);
    }

    public ConsumoEnergia atualizar(Long id, ConsumoEnergia consumoAtualizado) {
        return energiaRepository.findById(id).map(consumo -> {
            consumo.setSetor(consumoAtualizado.getSetor());
            consumo.setConsumoKw(consumoAtualizado.getConsumoKw());
            consumo.setTensao(consumoAtualizado.getTensao());
            consumo.setCorrente(consumoAtualizado.getCorrente());
            return energiaRepository.save(consumo);
        }).orElseThrow(() -> new RuntimeException("Consumo não encontrado"));
    }

    public void deletar(Long id) {
        energiaRepository.deleteById(id);
    }
}