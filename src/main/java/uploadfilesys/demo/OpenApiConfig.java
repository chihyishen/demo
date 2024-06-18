package uploadfilesys.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;

@OpenAPIDefinition
@Configuration
public class OpenApiConfig 
{
    @Bean
    public OpenAPI baseOpenAPI() {
        return new OpenAPI();
    }
}
