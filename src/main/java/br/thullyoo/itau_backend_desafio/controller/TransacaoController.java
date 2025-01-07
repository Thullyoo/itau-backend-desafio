package br.thullyoo.itau_backend_desafio.controller;

import br.thullyoo.itau_backend_desafio.DTO.TransacaoRequest;
import br.thullyoo.itau_backend_desafio.service.TransacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransacaoController {

    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

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

}
