package com.learnspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.LocaleResolver;
import com.learnspringboot.component.MyLocaleResolver;

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
		};
	}

	@Bean
	public LocaleResolver localeResolver() {
		return new MyLocaleResolver();
	}
}
