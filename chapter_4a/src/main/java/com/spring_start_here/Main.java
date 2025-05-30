package com.spring_start_here;

import com.spring_start_here.models.Comment;
import com.spring_start_here.proxies.NotificationProxyImpl;
import com.spring_start_here.repositories.CommentRepoImpl;
import com.spring_start_here.services.CommentService;

public class Main {
	public static void main(String[] args) {
		var commentRepo = new CommentRepoImpl();
		var notificationProxy = new NotificationProxyImpl();

		var comment = new Comment("Elliot Alderson", "the world itself is just one big hoax");

		var commentService = new CommentService(commentRepo, notificationProxy);
		commentService.publishComment(comment);
	}
}