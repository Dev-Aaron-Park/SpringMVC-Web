package com.aaron.springmvcproject.board;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.aaron.springmvcproject.comment.Comment;

public class BoardWriting {
	private BigDecimal spb_no;
	private String spb_writer;
	private String spb_title;
	private String spb_content;
	private Date spb_date;
	private String spb_color;
	
	public BoardWriting() {
		// TODO Auto-generated constructor stub
	}

	public BoardWriting(BigDecimal spb_no, String spb_writer, String spb_title, String spb_content, Date spb_date,
			String spb_color) {
		super();
		this.spb_no = spb_no;
		this.spb_writer = spb_writer;
		this.spb_title = spb_title;
		this.spb_content = spb_content;
		this.spb_date = spb_date;
		this.spb_color = spb_color;
	}

	public BigDecimal getSpb_no() {
		return spb_no;
	}

	public void setSpb_no(BigDecimal spb_no) {
		this.spb_no = spb_no;
	}

	public String getSpb_writer() {
		return spb_writer;
	}

	public void setSpb_writer(String spb_writer) {
		this.spb_writer = spb_writer;
	}

	public String getSpb_title() {
		return spb_title;
	}

	public void setSpb_title(String spb_title) {
		this.spb_title = spb_title;
	}

	public String getSpb_content() {
		return spb_content;
	}

	public void setSpb_content(String spb_content) {
		this.spb_content = spb_content;
	}

	public Date getSpb_date() {
		return spb_date;
	}

	public void setSpb_date(Date spb_date) {
		this.spb_date = spb_date;
	}

	public String getSpb_color() {
		return spb_color;
	}

	public void setSpb_color(String spb_color) {
		this.spb_color = spb_color;
	}
}
