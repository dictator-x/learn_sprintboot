package com.learnspringboot.config;

import com.learnspringboot.filter.MyFilter;
import com.learnspringboot.servlet.MyServlet;
import com.learnspringboot.listener.MyListener;
import java.util.Arrays;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ServerConfig {

	// @Bean
	// Need to set Jetty starter in build.gradle.
	// High priority than applicatoin.yml
	// public WebServerFactoryCustomizer sevletContainerCustomizer() {
	// 	return new WebServerFactoryCustomizer<JettyServletWebServerFactory>() {
	// 		@Override
	// 		public void customize(JettyServletWebServerFactory factory) {
	// 			factory.setPort(8080);
	// 		}
	// 	};
	// }

	@Bean
	public ServletRegistrationBean customizeServlet() {
		return new ServletRegistrationBean(new MyServlet(), "/myservlet");
	}

	@Bean
	public FilterRegistrationBean customizeFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new MyFilter());
		registrationBean.setUrlPatterns(Arrays.asList("/myservlet"));
		return registrationBean;
	}

	@Bean
	public ServletListenerRegistrationBean customizeListener() {
		ServletListenerRegistrationBean<MyListener> registrationBean = new ServletListenerRegistrationBean(new MyListener());
		return registrationBean;
	}
}
