package id.banking.accountservice.config;

import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerHeaderConfig {


    @Bean
    public OpenApiCustomizer globalHeaderOpenApiCustomizer() {
        return openApi -> openApi.getPaths().values().forEach(path ->
                path.readOperations().forEach(operation ->
                        operation.addParametersItem(
                                new Parameter()
                                        .in("header")
                                        .name("customer-id")
                                        .required(true)
                                        .schema(new StringSchema())
                                        .description("Customer ID")
                        )
                )
        );
    }
}
