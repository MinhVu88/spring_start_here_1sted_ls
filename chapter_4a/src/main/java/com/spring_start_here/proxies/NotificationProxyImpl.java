package com.spring_start_here.proxies;

import com.spring_start_here.models.Comment;

public class NotificationProxyImpl implements NotificationProxy {
	@Override
	public void sendNotification(Comment comment) {
		System.out.println(
			"notification(s) sent to " + comment.getAuthor() + 
			", based on his/her comment: " + comment.getContent()
		);
	}
}
