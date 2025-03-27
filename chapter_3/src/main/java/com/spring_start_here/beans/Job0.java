package com.spring_start_here.beans;

public class Job0 {
	private String title;
	private static int numberOfInstances;

	public Job0() {
		numberOfInstances++;
		System.out.println(numberOfInstances + " Job0 instance(s) created");
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return this.title;
	}
}
