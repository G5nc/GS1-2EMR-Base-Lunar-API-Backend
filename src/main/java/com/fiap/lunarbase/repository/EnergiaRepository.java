package com.fiap.lunarbase.repository;

import com.fiap.lunarbase.model.ConsumoEnergia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnergiaRepository extends JpaRepository<ConsumoEnergia, Long> {
}