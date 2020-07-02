package com.learnspringboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.View;
import java.util.Locale;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		Logger logger = LoggerFactory.getLogger(Application.class);
		// trace < debug < info < warn < error
		// logger.info("Hello World...................");
		logger.trace("Hello World...................");
	}

	@Bean
	public ViewResolver myViewResolver() {
		return new MyViewResolver();
	}

	private statck class MyViewResolver implements ViewResolver {

		@Override
		public View resolveViewName(String viewName, Locale locale) throws Exception {
			return null;
		}
	}
}
