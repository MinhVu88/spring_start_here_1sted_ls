package com.spring_start_here.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.spring_start_here.model.Comment;
import com.spring_start_here.proxy.NotificationProxy;
import com.spring_start_here.repo.CommentRepository;

@SuppressWarnings("unused")
// @Component
@Service
public class CommentService {
	private final CommentRepository commentRepo;
	private final NotificationProxy notificationProxy;
	
	@Autowired // optional if this's the only constructor in the class
	public CommentService(
		CommentRepository commentRepo, 
		@Qualifier("push") NotificationProxy notificationProxy
	) {
		this.commentRepo = commentRepo;
		this.notificationProxy = notificationProxy;
	}

	public void publishComment(Comment comment) {
		this.commentRepo.storeComment(comment);
		this.notificationProxy.sendNotification(comment);
	}
}
