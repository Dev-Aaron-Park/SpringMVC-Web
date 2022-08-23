package com.aaron.springmvcproject.member;

import java.util.Date;

public class Member {
	private String spm_id;
	private String spm_pw;
	private String spm_bcn;
	private String spm_name;
	private Date spm_birthday;
	private String spm_address;
	private String spm_photo;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String spm_id, String spm_pw, String spm_bcn, String spm_name, Date spm_birthday, String spm_address,
			String spm_photo) {
		super();
		this.spm_id = spm_id;
		this.spm_pw = spm_pw;
		this.spm_bcn = spm_bcn;
		this.spm_name = spm_name;
		this.spm_birthday = spm_birthday;
		this.spm_address = spm_address;
		this.spm_photo = spm_photo;
	}

	public String getSpm_id() {
		return spm_id;
	}

	public void setSpm_id(String spm_id) {
		this.spm_id = spm_id;
	}

	public String getSpm_pw() {
		return spm_pw;
	}

	public void setSpm_pw(String spm_pw) {
		this.spm_pw = spm_pw;
	}

	public String getSpm_bcn() {
		return spm_bcn;
	}

	public void setSpm_bcn(String spm_bcn) {
		this.spm_bcn = spm_bcn;
	}

	public String getSpm_name() {
		return spm_name;
	}

	public void setSpm_name(String spm_name) {
		this.spm_name = spm_name;
	}

	public Date getSpm_birthday() {
		return spm_birthday;
	}

	public void setSpm_birthday(Date spm_birthday) {
		this.spm_birthday = spm_birthday;
	}

	public String getSpm_address() {
		return spm_address;
	}

	public void setSpm_address(String spm_address) {
		this.spm_address = spm_address;
	}

	public String getSpm_photo() {
		return spm_photo;
	}

	public void setSpm_photo(String spm_photo) {
		this.spm_photo = spm_photo;
	}
}
