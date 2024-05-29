package com.sultan.vizier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;  
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@SpringBootApplication
public class VizierApplication {

	public static void main(String[] args) {
		SpringApplication.run(VizierApplication.class, args);
	}

}
