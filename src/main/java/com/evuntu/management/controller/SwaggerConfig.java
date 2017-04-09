package com.evuntu.management.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.google.common.base.Predicate;


/**
 * A Configuration file that allows the generation of Swagger
 */
@Configuration
@EnableWebMvc
@EnableSwagger2
@ComponentScan(basePackages = { "com.evuntu.management.EvuntuManagementRestController" })
public class SwaggerConfig {

	/**
	 * Every SwaggerSpringMvcPlugin bean is picked up by the swagger-mvc framework - allowing for multiple
	 * swagger groups i.e. same code base multiple swagger resource listings.
	 *
	 * @return SwaggerSpringMvcPlugin
	 */

	@Bean
	public Docket customImplementation() {

		return new Docket(DocumentationType.SWAGGER_2)
		.apiInfo(getApiInfo())
		.select()
		.paths(paths())
		.build()
		.pathMapping("/");
	}

	private Predicate<String> paths() {
		return PathSelectors.any();
	}

	/**
	 * A method that returns the API Info
	 * @return ApiInfo The Information including description
	 */
	public ApiInfo getApiInfo() {
		return  new ApiInfo(
				"Event Management Rest API",
				"This REST API is used for manage",
				"1e",
				"",
				"Evuntu Team",
				null,
				null
				);
	}
}