package com.fiap.lunarbase.controller;

import com.fiap.lunarbase.model.Sensor;
import com.fiap.lunarbase.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/sensores")
@CrossOrigin(origins = "*")
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @GetMapping
    public List<Sensor> listarTodos() {
        return sensorService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sensor> buscarPorId(@PathVariable Long id) {
        return sensorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/tipo/{tipo}")
    public List<Sensor> buscarPorTipo(@PathVariable String tipo) {
        return sensorService.buscarPorTipo(tipo);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Sensor criar(@RequestBody Sensor sensor) {
        return sensorService.salvar(sensor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sensor> atualizar(@PathVariable Long id, @RequestBody Sensor sensor) {
        try {
            Sensor atualizado = sensorService.atualizar(id, sensor);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        sensorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}