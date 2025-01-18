package br.thullyoo.itau_backend_desafio.service;

import br.thullyoo.itau_backend_desafio.DTO.TransacaoRequest;
import br.thullyoo.itau_backend_desafio.model.Transacao;
import br.thullyoo.itau_backend_desafio.repository.TransacaoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.OffsetDateTime;

import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TransacaoServiceTest {

    @InjectMocks
    private TransacaoService transacaoService;

    @Mock
    private TransacaoRepository transacaoRepository;

    @Test
    public void deveLancarIllegalArgumentException() throws Exception {
        TransacaoRequest transacao1 = new TransacaoRequest(50.0, OffsetDateTime.now().plusMinutes(5));
        assertThrows(IllegalArgumentException.class, () -> transacaoService.registrarTransacao(transacao1));

        TransacaoRequest transacao2 = new TransacaoRequest(-1.0, OffsetDateTime.now());
        assertThrows(IllegalArgumentException.class, () -> transacaoService.registrarTransacao(transacao1));
    }
}