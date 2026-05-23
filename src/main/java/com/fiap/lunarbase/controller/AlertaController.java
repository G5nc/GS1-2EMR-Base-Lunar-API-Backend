package com.fiap.lunarbase.controller;

import com.fiap.lunarbase.model.Alerta;
import com.fiap.lunarbase.service.AlertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/alertas")
@CrossOrigin(origins = "*")
public class AlertaController {

    @Autowired
    private AlertaService alertaService;

    @GetMapping
    public List<Alerta> listarTodos() {
        return alertaService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alerta> buscarPorId(@PathVariable Long id) {
        return alertaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nao-resolvidos")
    public List<Alerta> alertasNaoResolvidos() {
        return alertaService.alertasNaoResolvidos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Alerta criar(@RequestBody Alerta alerta) {
        return alertaService.salvar(alerta);
    }

    @PutMapping("/{id}/resolver")
    public ResponseEntity<Alerta> resolverAlerta(@PathVariable Long id) {
        try {
            Alerta resolvido = alertaService.resolverAlerta(id);
            return ResponseEntity.ok(resolvido);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        alertaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}