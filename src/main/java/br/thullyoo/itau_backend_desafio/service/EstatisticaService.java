package br.thullyoo.itau_backend_desafio.service;

import br.thullyoo.itau_backend_desafio.DTO.EstatisticaDTO;
import br.thullyoo.itau_backend_desafio.model.Transacao;
import br.thullyoo.itau_backend_desafio.repository.TransacaoRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstatisticaService {

    @Autowired
    private EntityManager entityManager;

    private final TransacaoRepository transacaoRepository;

    public EstatisticaService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    public EstatisticaDTO gerarEstatistica(){
        List<Transacao> listaTransacaoes = pegaTransacoesDosUltimosXSegundos(120);
        return gerarEstatisticaDTO(listaTransacaoes);
    }

    private List<Transacao> pegaTransacoesDosUltimosXSegundos(int segundos) {
        String queryString = "SELECT * FROM transacoes WHERE data_hora >= CURRENT_TIMESTAMP - INTERVAL '" + segundos + "' SECOND";
        return (List<Transacao>) entityManager.createNativeQuery(queryString, Transacao.class).getResultList();
    }

    private EstatisticaDTO gerarEstatisticaDTO(List<Transacao> listaTransacaoes){
        if (!listaTransacaoes.isEmpty()){
            int count = listaTransacaoes.size();
            Double sum = 0.0;
            Double min = listaTransacaoes.getFirst().getValor();
            Double max = listaTransacaoes.getFirst().getValor();
            for (Transacao transacao : listaTransacaoes){
                sum += transacao.getValor();
                if (transacao.getValor() >= max){
                    max = transacao.getValor();
                }
                if (transacao.getValor() <= min){
                    min = transacao.getValor();
                }
            }
            Double avg = sum / listaTransacaoes.size();
            return new EstatisticaDTO(count,sum,avg,min,max);
        }
        return new EstatisticaDTO(0,0.0,0.0,0.0,0.0);
    }
}
