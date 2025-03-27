package com.spring_start_here.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person4 {
	private String name = "Dominique DiPierro";
	private final Job0 job;

	@Autowired
	public Person4(@Qualifier("job_2") Job0 job) {
		this.job = job;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Job0 getJob() {
		return this.job;
	}
}
