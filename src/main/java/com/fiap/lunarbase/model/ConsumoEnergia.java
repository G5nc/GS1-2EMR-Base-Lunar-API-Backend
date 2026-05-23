package com.fiap.lunarbase.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "consumo_energia")
public class ConsumoEnergia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String setor;
    private Double consumoKw;
    private Double tensao;
    private Double corrente;
    private LocalDateTime dataHora;

    public ConsumoEnergia() {}

    public ConsumoEnergia(String setor, Double consumoKw, Double tensao, Double corrente) {
        this.setor = setor;
        this.consumoKw = consumoKw;
        this.tensao = tensao;
        this.corrente = corrente;
        this.dataHora = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getSetor() { return setor; }
    public void setSetor(String setor) { this.setor = setor; }
    public Double getConsumoKw() { return consumoKw; }
    public void setConsumoKw(Double consumoKw) { this.consumoKw = consumoKw; }
    public Double getTensao() { return tensao; }
    public void setTensao(Double tensao) { this.tensao = tensao; }
    public Double getCorrente() { return corrente; }
    public void setCorrente(Double corrente) { this.corrente = corrente; }
    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }
}