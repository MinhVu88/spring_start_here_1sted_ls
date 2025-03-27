package com.spring_start_here.repo;

import com.spring_start_here.model.Comment;

public class CommentRepoImpl implements CommentRepository {
	@Override
	public void storeComment(Comment comment) {
		System.out.println("storing comment: " + comment.getContent());
	}
}
