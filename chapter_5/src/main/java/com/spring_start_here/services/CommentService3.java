package com.spring_start_here.services;

import org.springframework.stereotype.Service;

@Service
public class CommentService3 {
	public CommentService3() {
		System.out.println(
			"\neager: CommentService3 bean immediately created & managed " +
			"by default via the Spring context initialization.\n"
		);
	}
}
