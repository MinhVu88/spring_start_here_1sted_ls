package com.spring_start_here.services;

import java.util.logging.Logger;

import com.spring_start_here.models.Comment;

public class CommentService0 {
	private Logger logger = Logger.getLogger(CommentService0.class.getName());

	public void publishComment0(Comment comment) {
		this.logger.info(comment.toString());
	}
}
