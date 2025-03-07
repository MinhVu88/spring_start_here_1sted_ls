package com.spring_start_here.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.spring_start_here.main.Person;

@Configuration
public class Config0 {
	@Bean(name = "Möstresticator")
	Person person0() {
		var p = new Person();
		p.setName("Maynard Keenan");
		return p;
	}

	@Bean(value = "Bastardometer")
	@Primary
	Person person1() {
		var p = new Person();
		p.setName("Adam Jones");
		return p;
	}

	@Bean("Membranophones")
	Person person2() {
		var p = new Person();
		p.setName("Danny Carey");
		return p;
	}

	@Bean
	String greetings() {
		return "eyyo wassup dude";
	}

	@Bean
	Integer number() {
		return 7;
	}
}
