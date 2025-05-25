package com.spring_start_here.repositories;

import com.spring_start_here.models.Comment;

public interface CommentRepository {
	void storeComment(Comment comment);
}
