// circular dependencies
package com.spring_start_here.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@SuppressWarnings("unused")
@Component
public class Job2 {
	private String title = "accountant";
	// private final Person3 person;

	// @Autowired
	// public Job2(Person3 person) {
	// 	this.person = person;
	// }

	public Job2() {}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	// public Person3 getPerson() {
	// 	return this.person;
	// }

	@Override
	public String toString() {
		return this.title;
	}
}
