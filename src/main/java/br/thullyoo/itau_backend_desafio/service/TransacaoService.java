package br.thullyoo.itau_backend_desafio.service;

import br.thullyoo.itau_backend_desafio.DTO.TransacaoRequest;
import br.thullyoo.itau_backend_desafio.model.Transacao;
import br.thullyoo.itau_backend_desafio.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;

    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    public void registrarTransacao(TransacaoRequest transacaoRequest) throws Exception {

        validarTransacao(transacaoRequest);

        Transacao transacao =  new Transacao();
        transacao.setDataHora(transacaoRequest.dataHora());
        transacao.setValor(transacaoRequest.valor());

        transacaoRepository.save(transacao);
    }

    private void validarTransacao(TransacaoRequest transacaoRequest){
        if (transacaoRequest.dataHora().isAfter(OffsetDateTime.now())){
            throw new IllegalArgumentException("Data não pode ser no futuro");
        }

        if (transacaoRequest.valor() < 0){
            throw new IllegalArgumentException("Valor da transação não pode ser negativo");
        }
    }
}
