package com.fiap.lunarbase.repository;

import com.fiap.lunarbase.model.Climatizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClimatizacaoRepository extends JpaRepository<Climatizacao, Long> {
}