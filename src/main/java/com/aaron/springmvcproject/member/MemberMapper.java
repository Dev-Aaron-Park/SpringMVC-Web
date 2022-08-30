package com.aaron.springmvcproject.member;

import java.util.List;

public interface MemberMapper {
	public abstract int join(Member m);
	
	public abstract int update(Member m);
	
	public abstract int delete(Member m);
	
	public abstract Member getMemberByID(Member m);

	public abstract List<Member> getMemberByIDList(Member m);
}
