package com.learnspringboot.config;

import com.learnspringboot.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAppConfig {

	@Bean // add return value to context, id by default is method name
	public HelloService helloService() {
		System.out.println("add helloService into context");
		return new HelloService();
	}
}
