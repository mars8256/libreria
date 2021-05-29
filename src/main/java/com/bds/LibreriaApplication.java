package com.bds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class LibreriaApplication  extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(LibreriaApplication.class, args);
	}

	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(LibreriaApplication.class);
	}
	 
		
}
