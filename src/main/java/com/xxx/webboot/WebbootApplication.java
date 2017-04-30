package com.xxx.webboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

@SpringBootApplication(scanBasePackages={"com.xxx.configure","com.xxx.webboot"}, exclude = {SecurityAutoConfiguration.class })
@EntityScan(basePackages={"com.xxx.webboot.entity"})
//@EnableJpaRepositories(basePackages = "com.xxx.webboot.repository")
public class WebbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebbootApplication.class, args);
	}
}
