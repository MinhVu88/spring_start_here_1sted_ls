package com.spring_start_here.beans;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class Job {
	private String title;

	@PostConstruct
	public void init() {
		this.title = "cybersecurity";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
