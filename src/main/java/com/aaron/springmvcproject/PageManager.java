package com.aaron.springmvcproject;

import java.math.BigDecimal;

public class PageManager {
	private String keyword;
	private BigDecimal start;
	private BigDecimal end;
	
	public PageManager() {
		// TODO Auto-generated constructor stub
	}

	public PageManager(String keyword, BigDecimal start, BigDecimal end) {
		super();
		this.keyword = keyword;
		this.start = start;
		this.end = end;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public BigDecimal getStart() {
		return start;
	}

	public void setStart(BigDecimal start) {
		this.start = start;
	}

	public BigDecimal getEnd() {
		return end;
	}

	public void setEnd(BigDecimal end) {
		this.end = end;
	}
}
