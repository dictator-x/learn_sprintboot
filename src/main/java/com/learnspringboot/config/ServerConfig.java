package com.learnspringboot.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import com.learnspringboot.servlet.MyServlet;


@Configuration
public class ServerConfig {

	@Bean
	// Need to set Jetty starter in build.gradle.
	// High priority than applicatoin.yml
	public WebServerFactoryCustomizer sevletContainerCustomizer() {
		return new WebServerFactoryCustomizer<JettyServletWebServerFactory>() {
			@Override
			public void customize(JettyServletWebServerFactory factory) {
				factory.setPort(8080);
			}
		};
	}

	@Bean
	public ServletRegistrationBean customizeServlet() {
		return new ServletRegistrationBean(new MyServlet(), "/myservlet");
	}
}
