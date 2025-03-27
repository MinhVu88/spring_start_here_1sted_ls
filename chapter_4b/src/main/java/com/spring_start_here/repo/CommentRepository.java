package com.spring_start_here.repo;

import com.spring_start_here.model.Comment;

public interface CommentRepository {
	void storeComment(Comment comment);
}
