package com.fiap.lunarbase.model;

import jakarta.persistence.*;

@Entity
@Table(name = "reservatorios")
public class Reservatorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String recurso;
    private Double capacidadeMaxima;
    private Double nivelAtual;
    private Double porcentagem;

    public Reservatorio() {}

    public Reservatorio(String nome, String recurso, Double capacidadeMaxima, Double nivelAtual) {
        this.nome = nome;
        this.recurso = recurso;
        this.capacidadeMaxima = capacidadeMaxima;
        this.nivelAtual = nivelAtual;
        this.porcentagem = (nivelAtual / capacidadeMaxima) * 100;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getRecurso() { return recurso; }
    public void setRecurso(String recurso) { this.recurso = recurso; }
    public Double getCapacidadeMaxima() { return capacidadeMaxima; }
    public void setCapacidadeMaxima(Double capacidadeMaxima) { this.capacidadeMaxima = capacidadeMaxima; }
    public Double getNivelAtual() { return nivelAtual; }
    public void setNivelAtual(Double nivelAtual) {
        this.nivelAtual = nivelAtual;
        this.porcentagem = (nivelAtual / this.capacidadeMaxima) * 100;
    }
    public Double getPorcentagem() { return porcentagem; }
    public void setPorcentagem(Double porcentagem) { this.porcentagem = porcentagem; }
}