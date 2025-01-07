package br.thullyoo.itau_backend_desafio.DTO;

import java.time.OffsetDateTime;

public record TransacaoRequest(Double valor, OffsetDateTime dataHora) {
}
