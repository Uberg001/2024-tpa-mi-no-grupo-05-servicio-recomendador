package ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Servicio recomendador de colaboradores")
                        .version("1.0")
                        .description("Este servicio brinda "));
    }
}