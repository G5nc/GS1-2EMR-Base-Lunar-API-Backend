package com.fiap.lunarbase.controller;

import com.fiap.lunarbase.model.Reservatorio;
import com.fiap.lunarbase.service.ReservatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reservatorios")
@CrossOrigin(origins = "*")
public class ReservatorioController {

    @Autowired
    private ReservatorioService reservatorioService;

    @GetMapping
    public List<Reservatorio> listarTodos() {
        return reservatorioService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservatorio> buscarPorId(@PathVariable Long id) {
        return reservatorioService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reservatorio criar(@RequestBody Reservatorio reservatorio) {
        return reservatorioService.salvar(reservatorio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservatorio> atualizar(@PathVariable Long id, @RequestBody Reservatorio reservatorio) {
        try {
            Reservatorio atualizado = reservatorioService.atualizar(id, reservatorio);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        reservatorioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}