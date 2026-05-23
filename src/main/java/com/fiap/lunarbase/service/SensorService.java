package com.fiap.lunarbase.service;

import com.fiap.lunarbase.model.Sensor;
import com.fiap.lunarbase.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    public List<Sensor> listarTodos() {
        return sensorRepository.findAll();
    }

    public Optional<Sensor> buscarPorId(Long id) {
        return sensorRepository.findById(id);
    }

    public Sensor salvar(Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    public Sensor atualizar(Long id, Sensor sensorAtualizado) {
        return sensorRepository.findById(id).map(sensor -> {
            sensor.setNome(sensorAtualizado.getNome());
            sensor.setTipo(sensorAtualizado.getTipo());
            sensor.setValor(sensorAtualizado.getValor());
            sensor.setUnidade(sensorAtualizado.getUnidade());
            return sensorRepository.save(sensor);
        }).orElseThrow(() -> new RuntimeException("Sensor não encontrado"));
    }

    public void deletar(Long id) {
        sensorRepository.deleteById(id);
    }

    public List<Sensor> buscarPorTipo(String tipo) {
        return sensorRepository.findByTipo(tipo);
    }
}