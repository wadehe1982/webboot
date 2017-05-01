package com.xxx.webboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xxx.webboot.client.KafkaClient;

@Controller
public class SecondController {
	
	@Autowired
	private KafkaClient kafkaClient;

	@RequestMapping("test2")
	public String test(){
		kafkaClient.sendMessage2KafkaTopic();
		return "xxx";
	}
}
