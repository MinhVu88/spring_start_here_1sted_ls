package com.spring_start_here.proxy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.spring_start_here.model.Comment;

@Component
@Qualifier("email")
public class EmailNotificationImpl implements NotificationProxy {
	@Override
	public void sendNotification(Comment comment) {
		System.out.println(
			"email sent to " + comment.getAuthor() + 
			", regarding the comment: " + comment.getContent()
		);
	}
}
