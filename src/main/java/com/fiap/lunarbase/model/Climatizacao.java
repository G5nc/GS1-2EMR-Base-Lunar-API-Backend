package com.fiap.lunarbase.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "climatizacao")
public class Climatizacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modulo;
    private Double temperatura;
    private Double umidade;
    private Double qualidadeAr;
    private LocalDateTime dataHora;

    public Climatizacao() {}

    public Climatizacao(String modulo, Double temperatura, Double umidade, Double qualidadeAr) {
        this.modulo = modulo;
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.qualidadeAr = qualidadeAr;
        this.dataHora = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getModulo() { return modulo; }
    public void setModulo(String modulo) { this.modulo = modulo; }
    public Double getTemperatura() { return temperatura; }
    public void setTemperatura(Double temperatura) { this.temperatura = temperatura; }
    public Double getUmidade() { return umidade; }
    public void setUmidade(Double umidade) { this.umidade = umidade; }
    public Double getQualidadeAr() { return qualidadeAr; }
    public void setQualidadeAr(Double qualidadeAr) { this.qualidadeAr = qualidadeAr; }
    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }
}