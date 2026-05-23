package com.fiap.lunarbase.controller;

import com.fiap.lunarbase.model.ConsumoEnergia;
import com.fiap.lunarbase.service.EnergiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/energia")
@CrossOrigin(origins = "*")
public class EnergiaController {

    @Autowired
    private EnergiaService energiaService;

    @GetMapping
    public List<ConsumoEnergia> listarTodos() {
        return energiaService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsumoEnergia> buscarPorId(@PathVariable Long id) {
        return energiaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ConsumoEnergia criar(@RequestBody ConsumoEnergia consumo) {
        return energiaService.salvar(consumo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsumoEnergia> atualizar(@PathVariable Long id, @RequestBody ConsumoEnergia consumo) {
        try {
            ConsumoEnergia atualizado = energiaService.atualizar(id, consumo);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        energiaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}