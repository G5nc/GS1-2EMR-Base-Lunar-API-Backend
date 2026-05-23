package com.fiap.lunarbase.controller;

import com.fiap.lunarbase.model.Climatizacao;
import com.fiap.lunarbase.service.ClimatizacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/climatizacao")
@CrossOrigin(origins = "*")
public class ClimatizacaoController {

    @Autowired
    private ClimatizacaoService climatizacaoService;

    @GetMapping
    public List<Climatizacao> listarTodos() {
        return climatizacaoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Climatizacao> buscarPorId(@PathVariable Long id) {
        return climatizacaoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Climatizacao criar(@RequestBody Climatizacao climatizacao) {
        return climatizacaoService.salvar(climatizacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Climatizacao> atualizar(@PathVariable Long id, @RequestBody Climatizacao climatizacao) {
        try {
            Climatizacao atualizado = climatizacaoService.atualizar(id, climatizacao);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        climatizacaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}