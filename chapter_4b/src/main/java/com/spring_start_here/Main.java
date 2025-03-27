package com.spring_start_here;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring_start_here.model.Comment;
import com.spring_start_here.service.CommentService;

public class Main {
	public static void main(String[] args) {
		try(var ctx = new AnnotationConfigApplicationContext(Config.class)) {
			var commentService = ctx.getBean(CommentService.class);
			var comment = new Comment("Darlene Alderson", "our democracy has been hacked");
			commentService.publishComment(comment);
		} catch(BeansException e) {
			System.out.println("\nException -> " + e.toString() + "\n");
		}
	}
}