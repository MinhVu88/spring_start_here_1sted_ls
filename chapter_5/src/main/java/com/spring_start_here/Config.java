package com.spring_start_here;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.spring_start_here.services.CommentService0;
import com.spring_start_here.services.CommentService5;

@Configuration
@ComponentScan(basePackages = {
	"com.spring_start_here.services",
	"com.spring_start_here.repositories",
	"com.spring_start_here.processors"
})
public class Config {
	@Bean
	public CommentService0 commentService0() {
		return new CommentService0();
	}

	@Bean
	@Scope("prototype")
	public CommentService5 commentService5() {
		return new CommentService5();
	}
}
