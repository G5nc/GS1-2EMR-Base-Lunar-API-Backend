package com.fiap.lunarbase.service;

import com.fiap.lunarbase.model.Alerta;
import com.fiap.lunarbase.repository.AlertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AlertaService {

    @Autowired
    private AlertaRepository alertaRepository;

    public List<Alerta> listarTodos() {
        return alertaRepository.findAll();
    }

    public Optional<Alerta> buscarPorId(Long id) {
        return alertaRepository.findById(id);
    }

    public Alerta salvar(Alerta alerta) {
        return alertaRepository.save(alerta);
    }

    public Alerta resolverAlerta(Long id) {
        return alertaRepository.findById(id).map(alerta -> {
            alerta.setResolvido(true);
            return alertaRepository.save(alerta);
        }).orElseThrow(() -> new RuntimeException("Alerta não encontrado"));
    }

    public void deletar(Long id) {
        alertaRepository.deleteById(id);
    }

    public List<Alerta> alertasNaoResolvidos() {
        return alertaRepository.findByResolvidoFalse();
    }
}
