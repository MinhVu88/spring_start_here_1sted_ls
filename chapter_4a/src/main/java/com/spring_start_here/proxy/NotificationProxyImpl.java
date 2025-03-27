package com.spring_start_here.proxy;

import com.spring_start_here.model.Comment;

public class NotificationProxyImpl implements NotificationProxy {
	@Override
	public void sendNotification(Comment comment) {
		System.out.println(
			"notification(s) sent to " + comment.getAuthor() + 
			", based on his/her comment: " + comment.getContent()
		);
	}
}
