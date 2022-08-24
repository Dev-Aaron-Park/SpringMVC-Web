package com.aaron.springmvcproject.comment;

import java.math.BigDecimal;
import java.util.Date;

public class Comment {
	private BigDecimal spc_no;
	private BigDecimal spc_board_no;
	private String spc_writer;
	private String spc_content;
	private Date spc_date;
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Comment(BigDecimal spc_no, BigDecimal spc_board_no, String spc_writer, String spc_content, Date spc_date) {
		super();
		this.spc_no = spc_no;
		this.spc_board_no = spc_board_no;
		this.spc_writer = spc_writer;
		this.spc_content = spc_content;
		this.spc_date = spc_date;
	}

	public BigDecimal getSpc_no() {
		return spc_no;
	}

	public void setSpc_no(BigDecimal spc_no) {
		this.spc_no = spc_no;
	}

	public BigDecimal getSpc_board_no() {
		return spc_board_no;
	}

	public void setSpc_board_no(BigDecimal spc_board_no) {
		this.spc_board_no = spc_board_no;
	}

	public String getSpc_writer() {
		return spc_writer;
	}

	public void setSpc_writer(String spc_writer) {
		this.spc_writer = spc_writer;
	}

	public String getSpc_content() {
		return spc_content;
	}

	public void setSpc_content(String spc_content) {
		this.spc_content = spc_content;
	}

	public Date getSpc_date() {
		return spc_date;
	}

	public void setSpc_date(Date spc_date) {
		this.spc_date = spc_date;
	}
}
