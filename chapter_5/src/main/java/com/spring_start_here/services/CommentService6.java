package com.spring_start_here.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_start_here.repositories.CommentRepository1;

@Service
public class CommentService6 {
	@Autowired
	private CommentRepository1 commentRepo;

	public CommentRepository1 getCommentRepo() {
		return this.commentRepo;
	}
}
