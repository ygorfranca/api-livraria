package br.com.athome.apilivraria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


//Adicionar as annotations para configuracao
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket livroApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.athome.apilivraria"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(metaInfo());
	}
	
	public ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfoBuilder()
				.title("Livraria API REST") 
				.description("API REST Para Livraria")
				.version("1.0")
				.contact(new Contact("Ygor de Souza França", "https://github.com/ygorfranca", "ygorfranca@gmail.com"))
				.license("Apache License Version 2.0")
				.licenseUrl("https://www.apache.org/license.html")
				.termsOfServiceUrl("Terms of Service")
				.build();
		
		return apiInfo;
	}
	
}
