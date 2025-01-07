package br.thullyoo.itau_backend_desafio.model;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "TRANSACOES")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double valor;

    private OffsetDateTime dataHora;

    public Transacao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(OffsetDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
