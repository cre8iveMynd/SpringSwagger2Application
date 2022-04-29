package com.javabrains;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class SpringSwagger2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSwagger2Application.class, args);
	}


	@Bean
	public Docket swaggerConfiguration(){

		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/*"))
				.apis(RequestHandlerSelectors.basePackage("com.javabrains"))
				.build()
				.apiInfo(apiDetails());

	}

	private ApiInfo apiDetails(){

		return new ApiInfo(
				"Address book API",
				"Sample API for JAV BRain tutoril",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Jayesh D","http://localhost8080","aab.com"),
				"API LICENSE",
				"http://localhost",
				Collections.emptyList());
	}

}



