package br.com.peladasbr.gerenciadordepeladas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gerenciamento de Partidas de Futebol")
                        .description("API para gerenciamento de partidas e times de futebol amador")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Mardonio S Costa")
                                .email("Mardonio@live.com")
                                .url("https://cartao.servicosmsc.com.br")));
    }
}
