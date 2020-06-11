package com.cognizant.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@SpringBootApplication
public class CapitalOneServiceApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(CapitalOneServiceApplication.class, args);
	}
	
	@Bean
	public HandlerMapping handlerMapping() {
		return new RequestMappingHandlerMapping();
	}

	@Bean
	public HandlerAdapter handlerAdapter() {
		return new RequestMappingHandlerAdapter();
	}

	/*
	 * @Bean public HandlerExceptionResolver handlerExceptionResolver() { return new
	 * HandlerExceptionResolver() {
	 * 
	 * @Override public ModelAndView resolveException(HttpServletRequest request,
	 * HttpServletResponse response, Object handler, Exception ex) { return null; }
	 * }; }
	 */

}
