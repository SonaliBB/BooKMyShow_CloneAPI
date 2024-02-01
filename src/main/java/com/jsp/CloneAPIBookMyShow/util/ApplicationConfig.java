package com.jsp.CloneAPIBookMyShow.util;


import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApplicationConfig {
	@Bean
	public Docket getDoket() {
		Contact contact=new Contact("sonali",null,"sonalibhadalkar99@gmail.com");
	List<VendorExtension> extensions=new ArrayList<VendorExtension>();
	ApiInfo apiInfo=new ApiInfo("BookMyShowCloneApi","it is used to book a ticket online","1.0", "www.google.com", contact, "google.license", "google@gmail.com", extensions);
			return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.jsp.CloneAPIBookMyShow")).build().apiInfo(apiInfo).useDefaultResponseMessages(false);
	}
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
}
