package com.xxx.webboot.controller;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController("config")
//make sure the config items in git can be refreshed when invoke /refresh
//Note: To refresh it, need send a POST request.
//Example: curl -d "" "http://localhost:8080/myboot/refresh"
@RefreshScope 
public class CloudConfigController {
	
	/*
	 * Two ways to get properties configuration items
	 * first is this one: auto wired a Environment object
	 * and then getProperty.
	 * The second way is use @Value annotation.
	 * 
	 * Note: If this failed to load properties, consider start up
	 * Spring cloud config side configserver or just disable this.
	 */
//	@Autowired
	private Environment environment;
	
	//TODO to use this,need to start up configserver
//	@Value("${mysqldb.datasource.username}")
	private String name;
	
	@RequestMapping(name = "test")
	public String test(){
		System.out.println(environment.getProperty("name"));
		return name;
	}
	
}
