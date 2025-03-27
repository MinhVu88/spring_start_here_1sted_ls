package com.spring_start_here.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person2 {
	private String name;
	// private Job1 job;

	// Field-Based Dependency Injection (not recommended)
	// @Autowired
	// private Job1 job;

	private final Job1 job;

	// Constructor-Based Dependency Injection (recommended)
	@Autowired
	public Person2(Job1 job) {
		this.job = job;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Job1 getJob() {
		return this.job;
	}

	// Setter-Based Dependency Injection (not recommended)
	// @Autowired
	// public void setJob(Job1 job) {
	// 	this.job = job;
	// }
}
