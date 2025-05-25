package com.spring_start_here.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.spring_start_here.aspects.LoggingAspect;
import com.spring_start_here.aspects.SecurityAspect;

@Configuration
@ComponentScan(basePackages = {"com.spring_start_here.services"})
@EnableAspectJAutoProxy
public class Config1 {
	@Bean
	public LoggingAspect loggingAspect() {
		return new LoggingAspect();
	}

	@Bean
	public SecurityAspect securityAspect() {
		return new SecurityAspect();
	}
}
