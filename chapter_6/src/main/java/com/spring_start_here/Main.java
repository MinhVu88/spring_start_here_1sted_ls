package com.spring_start_here;

import java.util.logging.Logger;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring_start_here.configs.Config0;
import com.spring_start_here.configs.Config1;
import com.spring_start_here.models.Comment;
import com.spring_start_here.services.CommentService0;
import com.spring_start_here.services.CommentService1;

public class Main {
	private static Logger logger = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) {
		try(
			var ctx0 = new AnnotationConfigApplicationContext(Config0.class);
			var ctx1 = new AnnotationConfigApplicationContext(Config1.class)
		) {
			System.out.println("\t\t[ WITHOUT ASPECTS ]\n");
			var cs0 = ctx0.getBean("commentService0", CommentService0.class);
			Comment c0 = new Comment("CommentService0", "the non-intercepted publishComment0 method");
			cs0.publishComment0(c0);

			System.out.println("\n\t\t[ WITH ASPECTS ]\n");
			var cs1 = ctx1.getBean(CommentService1.class);
			Comment c1 = new Comment("CommentService1", "the intercepted publishComment1 method");
			cs1.publishComment1(c1); 

			System.out.println("---------------------------------------------");
			
			logger.info(
				cs1.publishComment2(
					new Comment(
						"CommentService1", 
						"the intercepted publishComment2 method (params/args & returned value included)"
					)
				)
			);

			System.out.println("---------------------------------------------");

			Comment c2 = new Comment(
				"CommentService1", 
				"the non-intercepted editComment & intercepted deleteComment methods"
			);

			cs1.editComment(c2);
			cs1.deleteComment(c2);

			System.out.println("---------------------------------------------");

			cs1.publishComment3(
				new Comment(
					"CommentService1", 
					"the intercepted publishComment3 method"
				)
			);

			System.out.println("---------------------------------------------");

			cs1.publishComment4(
				new Comment(
					"CommentService1", 
					"the intercepted publishComment4 method"
				)
			);
		} catch(BeansException e) {
			System.out.println("\nException -> " + e.toString() + "\n");
		}
	}
}