package com.learnspringboot.config;

import com.learnspringboot.component.MyLocaleResolver;
import com.learnspringboot.component.LoginHandlerInterceptor;
import com.learnspringboot.interceptor.SimpleAuthenticationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
// @EnableWebMvc // disable all default springMVC config by springBoot.
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/aaa").setViewName("success");
	}


	@Bean
	public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addViewControllers(ViewControllerRegistry registry) {
				registry.addViewController("/index.html").setViewName("login");
				registry.addViewController("/").setViewName("login");
			}

			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				registry
					.addInterceptor(new SimpleAuthenticationInterceptor())
					.addPathPatterns("/r/**");
					// .excludePathPatterns("/index.html", "/", "/user/login");
			}
		};
	}

	@Bean
	public LocaleResolver localeResolver() {
		return new MyLocaleResolver();
	}
}
