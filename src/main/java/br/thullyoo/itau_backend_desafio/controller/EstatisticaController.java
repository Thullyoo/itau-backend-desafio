package br.thullyoo.itau_backend_desafio.controller;

import br.thullyoo.itau_backend_desafio.DTO.EstatisticaDTO;
import br.thullyoo.itau_backend_desafio.repository.TransacaoRepository;
import br.thullyoo.itau_backend_desafio.service.EstatisticaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Estatística Controller")
public class EstatisticaController {

    private final EstatisticaService estatisticaService;

    public EstatisticaController(EstatisticaService estatisticaService) {
        this.estatisticaService = estatisticaService;
    }

    @Operation(summary = "Registrar transação", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Estátistica gerada com sucesso!"),
    })
    @GetMapping(value = "estatistica")
    public ResponseEntity<EstatisticaDTO> gerarEstatistica(){
        return ResponseEntity.ok(estatisticaService.gerarEstatistica());
    }

}
