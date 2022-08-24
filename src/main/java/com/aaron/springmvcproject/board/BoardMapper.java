package com.aaron.springmvcproject.board;

import java.util.List;

import com.aaron.springmvcproject.PageManager;
import com.aaron.springmvcproject.comment.Comment;
import com.aaron.springmvcproject.member.Member;

public interface BoardMapper {
	public abstract int create(BoardWriting bw);
	
	public abstract int delete(BoardWriting bw);

	public abstract BoardWriting detail(BoardWriting bw);

	public abstract List<BoardWriting> readAllWriting(PageManager pm);
	
	public abstract int readAllCount(PageManager pm);
	
	public abstract int edit(BoardWriting mw);
	
	public abstract int getMemberPostingsCount(Member m);
	
	public abstract List<Comment> getComment(BoardWriting bw);
}
