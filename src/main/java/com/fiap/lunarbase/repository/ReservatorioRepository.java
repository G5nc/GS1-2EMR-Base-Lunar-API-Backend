package com.fiap.lunarbase.repository;

import com.fiap.lunarbase.model.Reservatorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReservatorioRepository extends JpaRepository<Reservatorio, Long> {
    List<Reservatorio> findByRecurso(String recurso);
}