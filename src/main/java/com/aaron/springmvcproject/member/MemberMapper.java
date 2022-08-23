package com.aaron.springmvcproject.member;

public interface MemberMapper {
	public abstract int join(Member m);
	
	public abstract int update(Member m);
	
	public abstract int delete(Member m);
	
	public abstract Member getMemberByID(Member m);
}
