package com.revature.p2backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class P2backendApplication {

	public static void main(String[] args) {
		SpringApplication.run(P2backendApplication.class, args);
	}

}
