package br.thullyoo.itau_backend_desafio.controller;

import br.thullyoo.itau_backend_desafio.DTO.EstatisticaDTO;
import br.thullyoo.itau_backend_desafio.repository.TransacaoRepository;
import br.thullyoo.itau_backend_desafio.service.EstatisticaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstatisticaController {

    private final EstatisticaService estatisticaService;

    public EstatisticaController(EstatisticaService estatisticaService) {
        this.estatisticaService = estatisticaService;
    }

    @GetMapping(value = "estatistica")
    public ResponseEntity<EstatisticaDTO> gerarEstatistica(){
        return ResponseEntity.ok(estatisticaService.gerarEstatistica());
    }

}
