package com.trickyrat.springbootstarter;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@MapperScan("com.trickyrat.springbootstarter.mapper")
@SpringBootApplication
public class SpringBootStarterApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootStarterApplication.class, args);
    }

    @Bean
    public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Books API").version(appVersion)
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }

}
