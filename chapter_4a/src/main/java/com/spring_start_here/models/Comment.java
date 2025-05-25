package com.spring_start_here.models;

public class Comment {
	private String author, content;

	public Comment() {}

	public Comment(String author, String content) {
		this.author = author;
		this.content = content;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "author: " + this.author + " | content" + this.content;
	}
}
