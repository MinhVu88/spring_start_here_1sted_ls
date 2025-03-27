// circular dependencies
package com.spring_start_here.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@SuppressWarnings("unused")
@Component
public class Person3 {
	private String name = "Angela Moss";
	// private final Job2 job;
	
	// @Lazy is 1 of the workarounds to solve the circular dependency problem (not recommended)
	// @Autowired
	// public Person3(@Lazy Job2 job) {
	// 	this.job = job;
	// }

	public Person3() {}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// public Job2 getJob() {
	// 	return this.job;
	// }

	@Override
	public String toString() {
		return this.name;
	}	
}
