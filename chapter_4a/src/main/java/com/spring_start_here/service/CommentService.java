package com.spring_start_here.service;

import com.spring_start_here.model.Comment;
import com.spring_start_here.proxy.NotificationProxy;
import com.spring_start_here.repo.CommentRepository;

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
