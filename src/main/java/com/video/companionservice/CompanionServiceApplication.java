package com.video.companionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class CompanionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanionServiceApplication.class, args);
	}

}
