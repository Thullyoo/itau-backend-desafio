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
}
