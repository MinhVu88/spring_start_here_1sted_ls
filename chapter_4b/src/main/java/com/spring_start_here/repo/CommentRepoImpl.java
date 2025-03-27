package com.spring_start_here.repo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.spring_start_here.model.Comment;

@SuppressWarnings("unused")
// @Component
@Repository
public class CommentRepoImpl implements CommentRepository {
	@Override
	public void storeComment(Comment comment) {
		System.out.println("storing comment: " + comment.getContent());
	}
}
