package com.aaron.springmvcproject.board;

import java.util.List;

import com.aaron.springmvcproject.PageManager;

public interface BoardMapper {
	public abstract int create(BoardWriting bw);
	
	public abstract int delete(BoardWriting bw);

	public abstract BoardWriting detail(BoardWriting bw);

	public abstract List<BoardWriting> readAllWriting(PageManager pm);
	
	public abstract int readAllCount(PageManager pm);
	
	public abstract int edit(PageManager pm);
}
