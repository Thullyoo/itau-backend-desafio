package br.thullyoo.itau_backend_desafio.repository;

import br.thullyoo.itau_backend_desafio.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
