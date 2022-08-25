package com.aaron.springmvcproject.comment;

public interface CommentMapper {
	public abstract int create(Comment c);
	
	public abstract int delete(Comment c);
}
