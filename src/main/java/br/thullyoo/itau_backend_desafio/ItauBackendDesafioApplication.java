package br.thullyoo.itau_backend_desafio;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Desafio Itáu Back-end", version = "1.0", description = "API para salvar Transações e gerar Estatísticas"))
public class ItauBackendDesafioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItauBackendDesafioApplication.class, args);
	}

}
