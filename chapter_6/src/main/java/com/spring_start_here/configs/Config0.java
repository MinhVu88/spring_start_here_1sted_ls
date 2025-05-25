package com.spring_start_here.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring_start_here.services.CommentService0;

@Configuration
public class Config0 {
	@Bean
	public CommentService0 commentService0() {
		return new CommentService0();
	}
}
