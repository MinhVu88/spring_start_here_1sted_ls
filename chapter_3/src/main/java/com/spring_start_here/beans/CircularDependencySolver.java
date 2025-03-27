package com.spring_start_here.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CircularDependencySolver {
	private final Person3 person;
	private final Job2 job;
	
	@Autowired
	public CircularDependencySolver(Person3 person, Job2 job) {
		this.person = person;
		this.job = job;
	}

	@Override
	public String toString() {
		return "Person3: " + this.person + " | job: " + this.job;
	}
}
