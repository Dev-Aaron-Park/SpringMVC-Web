package com.aaron.springmvcproject.gallery;

import java.math.BigDecimal;
import java.util.Date;

public class Gallery {
	private BigDecimal spg_no;
	private String spg_writer;
	private String spg_photo;
	private String spg_memo;
	private Date spg_date;
	
	public Gallery() {
		// TODO Auto-generated constructor stub
	}

	public Gallery(BigDecimal spg_no, String spg_writer, String spg_photo, String spg_memo, Date spg_date) {
		super();
		this.spg_no = spg_no;
		this.spg_writer = spg_writer;
		this.spg_photo = spg_photo;
		this.spg_memo = spg_memo;
		this.spg_date = spg_date;
	}

	public BigDecimal getSpg_no() {
		return spg_no;
	}

	public void setSpg_no(BigDecimal spg_no) {
		this.spg_no = spg_no;
	}

	public String getSpg_writer() {
		return spg_writer;
	}

	public void setSpg_writer(String spg_writer) {
		this.spg_writer = spg_writer;
	}

	public String getSpg_photo() {
		return spg_photo;
	}

	public void setSpg_photo(String spg_photo) {
		this.spg_photo = spg_photo;
	}

	public String getSpg_memo() {
		return spg_memo;
	}

	public void setSpg_memo(String spg_memo) {
		this.spg_memo = spg_memo;
	}

	public Date getSpg_date() {
		return spg_date;
	}

	public void setSpg_date(Date spg_date) {
		this.spg_date = spg_date;
	}
}
