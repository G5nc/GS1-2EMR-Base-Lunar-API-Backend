package com.fiap.lunarbase.service;

import com.fiap.lunarbase.model.Climatizacao;
import com.fiap.lunarbase.repository.ClimatizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClimatizacaoService {

    @Autowired
    private ClimatizacaoRepository climatizacaoRepository;

    public List<Climatizacao> listarTodos() {
        return climatizacaoRepository.findAll();
    }

    public Optional<Climatizacao> buscarPorId(Long id) {
        return climatizacaoRepository.findById(id);
    }

    public Climatizacao salvar(Climatizacao climatizacao) {
        return climatizacaoRepository.save(climatizacao);
    }

    public Climatizacao atualizar(Long id, Climatizacao climatizacaoAtualizado) {
        return climatizacaoRepository.findById(id).map(climatizacao -> {
            climatizacao.setModulo(climatizacaoAtualizado.getModulo());
            climatizacao.setTemperatura(climatizacaoAtualizado.getTemperatura());
            climatizacao.setUmidade(climatizacaoAtualizado.getUmidade());
            climatizacao.setQualidadeAr(climatizacaoAtualizado.getQualidadeAr());
            return climatizacaoRepository.save(climatizacao);
        }).orElseThrow(() -> new RuntimeException("Climatização não encontrada"));
    }

    public void deletar(Long id) {
        climatizacaoRepository.deleteById(id);
    }
}