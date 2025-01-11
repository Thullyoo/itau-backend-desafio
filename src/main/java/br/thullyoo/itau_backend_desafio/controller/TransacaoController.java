package br.thullyoo.itau_backend_desafio.controller;

import br.thullyoo.itau_backend_desafio.DTO.TransacaoRequest;
import br.thullyoo.itau_backend_desafio.service.TransacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Transacao Controller")
public class TransacaoController {

    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @Operation(summary = "Registrar transação", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Transação registrada com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Falha ao registrar transação"),
            @ApiResponse(responseCode = "422", description = "Argumentos inválidos para requisição")
    })
    @PostMapping(value = "/transacao")
    public ResponseEntity<Void> registrarTransacao(@RequestBody TransacaoRequest transacaoRequest){
        try{
            transacaoService.registrarTransacao(transacaoRequest);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.unprocessableEntity().build();
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }


    @Operation(summary = "Deletar todas as transação", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Transações deletadas com sucesso!")
    })
    @DeleteMapping(value = "/transacao")
    public ResponseEntity<Void> deletarTransacoes(){
        transacaoService.deletarTransacoes();
        return ResponseEntity.ok(null);
    }
}
