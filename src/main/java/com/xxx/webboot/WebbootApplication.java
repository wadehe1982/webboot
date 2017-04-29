package com.xxx.webboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages={"com.xxx.webboot.entity"})
@EnableJpaRepositories(basePackages = "com.xxx.webboot.repository")
public class WebbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebbootApplication.class, args);
	}
}
