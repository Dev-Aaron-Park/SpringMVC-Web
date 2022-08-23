package com.aaron.springmvcproject;

public class SMPAttribute {
	private int boardPerPage;
	
	public SMPAttribute() {
		// TODO Auto-generated constructor stub
	}

	public SMPAttribute(int boardPerPage) {
		super();
		this.boardPerPage = boardPerPage;
	}

	public int getBoardPerPage() {
		return boardPerPage;
	}

	public void setBoardPerPage(int boardPerPage) {
		this.boardPerPage = boardPerPage;
	}
}
