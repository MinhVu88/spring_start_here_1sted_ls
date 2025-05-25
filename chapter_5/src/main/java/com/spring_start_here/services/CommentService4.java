package com.spring_start_here.services;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Lazy
@Service
public class CommentService4 {
	public CommentService4() {
		System.out.println(
			"lazy: this output proves that CommentService4 bean, though already registered in the context, " +
			"is being referenced/injected/accessed for the 1st time, and consequently instantiated.");
	}
}
