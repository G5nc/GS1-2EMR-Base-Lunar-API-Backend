package com.fiap.lunarbase.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "alertas")
public class Alerta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;
    private String mensagem;
    private String gravidade;
    private Boolean resolvido;
    private LocalDateTime dataHora;

    public Alerta() {}

    public Alerta(String tipo, String mensagem, String gravidade) {
        this.tipo = tipo;
        this.mensagem = mensagem;
        this.gravidade = gravidade;
        this.resolvido = false;
        this.dataHora = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }
    public String getGravidade() { return gravidade; }
    public void setGravidade(String gravidade) { this.gravidade = gravidade; }
    public Boolean getResolvido() { return resolvido; }
    public void setResolvido(Boolean resolvido) { this.resolvido = resolvido; }
    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }
}