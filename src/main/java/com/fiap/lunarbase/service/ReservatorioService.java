package com.fiap.lunarbase.service;

import com.fiap.lunarbase.model.Reservatorio;
import com.fiap.lunarbase.repository.ReservatorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReservatorioService {

    @Autowired
    private ReservatorioRepository reservatorioRepository;

    public List<Reservatorio> listarTodos() {
        return reservatorioRepository.findAll();
    }

    public Optional<Reservatorio> buscarPorId(Long id) {
        return reservatorioRepository.findById(id);
    }

    public Reservatorio salvar(Reservatorio reservatorio) {
        return reservatorioRepository.save(reservatorio);
    }

    public Reservatorio atualizar(Long id, Reservatorio reservatorioAtualizado) {
        return reservatorioRepository.findById(id).map(reservatorio -> {
            reservatorio.setNome(reservatorioAtualizado.getNome());
            reservatorio.setRecurso(reservatorioAtualizado.getRecurso());
            reservatorio.setCapacidadeMaxima(reservatorioAtualizado.getCapacidadeMaxima());
            reservatorio.setNivelAtual(reservatorioAtualizado.getNivelAtual());
            return reservatorioRepository.save(reservatorio);
        }).orElseThrow(() -> new RuntimeException("Reservatório não encontrado"));
    }

    public void deletar(Long id) {
        reservatorioRepository.deleteById(id);
    }
}