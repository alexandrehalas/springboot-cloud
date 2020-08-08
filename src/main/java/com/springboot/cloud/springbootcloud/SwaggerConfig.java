package com.springboot.cloud.springbootcloud;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public static final Contact DEFAULT_CONTACT = new Contact("Alexandre Halas", "", "alexandrehalas@gmail.com");
	
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
				"Api Title",
				"Api Description",
				"1.0",
				"urn:tos",
				DEFAULT_CONTACT,
				"MIT",
				"https://opensource.org/licenses/MIT",
				new ArrayList<>());

	private static final Set<String> DEFAULT_PRODUCES_AND_COSUMES = new HashSet<>(
			Arrays.asList(
				"application/json",
				"application/xml"));
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAULT_API_INFO)
				.produces(DEFAULT_PRODUCES_AND_COSUMES)
				.consumes(DEFAULT_PRODUCES_AND_COSUMES);
	}
	
}
