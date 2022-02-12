/**
 * 
 */
package com.ericsson.example.advanced.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Sandipan Chakraborty
 * 
 * This is a Swagger config class
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	
		@Bean
	   public Docket productApi() {
	      return new Docket(DocumentationType.SWAGGER_2)
	    		  		.select()
	    		  		.apis(RequestHandlerSelectors.basePackage("com.ericsson.example.advanced.controller"))
	    		  		.build();
	   }
		
}
