package com.spring_start_here.proxies;

import com.spring_start_here.models.Comment;

public interface NotificationProxy {
	void sendNotification(Comment comment);
}
