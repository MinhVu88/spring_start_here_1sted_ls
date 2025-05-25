package com.spring_start_here.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.spring_start_here.models.Comment;
import com.spring_start_here.processors.CommentProcessor;

@Service
public class CommentService7 {
	@Autowired
	private ApplicationContext context;

	public String processComment(Comment comment) {
		CommentProcessor cp = context.getBean(CommentProcessor.class);
		
		StringBuffer processedComment = new StringBuffer();
		
		String[] profanities = {
			"bastard", "shit", "asshole", "motherfucker", 
			"bitch", "bollocks", "wanker", "cunt",
			"faggot", "dumbfuck", "dipshit", "dickweed",
			"bullshit", "bastard ", "whore", "slut", 
			"fuck", "cocksucker", "dickhead", "fuck-off", 
			"bloody-hell", "son-of-a-bitch", "kiss-my-ass", "full-of-shit"
		};

		if(cp.validateComment(comment)) {
			String content = comment.getContent().replaceAll("[^a-zA-Z0-9\\s]", "");

			Pattern pattern = Pattern.compile("\\S+");
			Matcher matcher = pattern.matcher(content);

			List<String> commentWords = new ArrayList<>();

			while(matcher.find()) {
				commentWords.add(matcher.group());
			}

			if(commentWords.size() > profanities.length) {
				return "- ERROR: not enough swear words (" + profanities.length + 
							 ") to uniquely replace each word in the comment (" + commentWords.size() + ")";
			}

			List<String> swearWords = new ArrayList<>(Arrays.asList(profanities));
			Collections.shuffle(swearWords);
			List<String> shuffledSwearWords = swearWords.subList(0, commentWords.size());

			matcher.reset();

			int index = 0;

			while(matcher.find()) {
				String switchedSwearWord = shuffledSwearWords.get(index++);
				matcher.appendReplacement(processedComment, Matcher.quoteReplacement(switchedSwearWord));
			}

			matcher.appendTail(processedComment);
		} else {
			return "- Invalid comment => " + comment;
		}

		return "- Author: " + comment.getAuthor() + " | content: " + processedComment.toString();
	}
}
