package com.spring_start_here.services;

import com.spring_start_here.models.Comment;
import com.spring_start_here.proxies.NotificationProxy;
import com.spring_start_here.repositories.CommentRepository;

public class CommentService {
	private final CommentRepository commentRepo;
	private final NotificationProxy notificationProxy;
	
	public CommentService(
		CommentRepository commentRepo, 
		NotificationProxy notificationProxy
	) {
		this.commentRepo = commentRepo;
		this.notificationProxy = notificationProxy;
	}

	public void publishComment(Comment comment) {
		this.commentRepo.storeComment(comment);
		this.notificationProxy.sendNotification(comment);
	}
}
