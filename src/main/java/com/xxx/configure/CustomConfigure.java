package com.xxx.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xxx.webboot.model.UserDTO;

@Configuration
public class CustomConfigure {
	
	@Bean
	public UserDTO userDTO(){
		System.out.println("init UserDTO");
		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(1L);
		userDTO.setUserName("name1");
		return userDTO;
	}

}
