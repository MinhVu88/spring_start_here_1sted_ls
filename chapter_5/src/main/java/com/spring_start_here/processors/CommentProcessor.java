package com.spring_start_here.processors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.spring_start_here.models.Comment;
import com.spring_start_here.repositories.CommentRepository1;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CommentProcessor {
	@SuppressWarnings("unused")
	@Autowired
	private CommentRepository1 commentRepo;

	private Comment comment;
	
	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public Comment getComment() {
		return this.comment;
	}

	public boolean validateComment(Comment comment) {
		setComment(comment);

		return getComment().getAuthor() == null || 
					 getComment().getAuthor().isBlank() ||
					 getComment().getContent() == null || 
					 getComment().getContent().isBlank() 
					 ? false 
					 : getComment().toString().contains(getComment().getAuthor()) && 
					 	 getComment().toString().contains(getComment().getContent());
	}
}
