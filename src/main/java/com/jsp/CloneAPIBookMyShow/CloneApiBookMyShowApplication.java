package com.jsp.CloneAPIBookMyShow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages = {"com.jsp.CloneAPIBookMyShow.*"})
@EnableJpaRepositories("com.jsp.CloneAPIBookMyShow.repository")
public class CloneApiBookMyShowApplication {


	
	public static void main(String[] args) {
		SpringApplication.run(CloneApiBookMyShowApplication.class, args);
		
	}

}
