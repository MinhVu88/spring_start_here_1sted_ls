package com.spring_start_here.proxies;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.spring_start_here.models.Comment;

@Component
@Qualifier("push")
public class PushNotificationImpl implements NotificationProxy {
	@Override
	public void sendNotification(Comment comment) {
		System.out.println(
			"push notification sent to " + comment.getAuthor() + 
			", regarding the comment: " + comment.getContent()
		);
	}
}
