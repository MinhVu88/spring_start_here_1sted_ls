package com.spring_start_here.repositories;

import com.spring_start_here.models.Comment;

public class CommentRepoImpl implements CommentRepository {
	@Override
	public void storeComment(Comment comment) {
		System.out.println("storing comment: " + comment.getContent());
	}
}
