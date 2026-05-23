package com.fiap.lunarbase.repository;

import com.fiap.lunarbase.model.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AlertaRepository extends JpaRepository<Alerta, Long> {
    List<Alerta> findByResolvidoFalse();
    List<Alerta> findByGravidade(String gravidade);
}