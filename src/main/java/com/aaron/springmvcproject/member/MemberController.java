package com.aaron.springmvcproject.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {
	
	@Autowired
	private MemberDAO mDAO;
	
	@RequestMapping(value = "/join.go", method = RequestMethod.GET)
	public String joinGo(HttpServletRequest req) {
		mDAO.isLogined(req);
		req.setAttribute("contentsPage", "member/join.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/join.do", method = RequestMethod.POST)
	public String joinDo(Member m, HttpServletRequest req) {
		mDAO.join(m, req);
		mDAO.isLogined(req);
		req.setAttribute("contentsPage", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String loginDo(Member m, HttpServletRequest req) {
		mDAO.login(m, req);
		mDAO.isLogined(req);
		req.setAttribute("contentsPage", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logoutDo(Member m, HttpServletRequest req) {
		mDAO.logout(req);
		mDAO.isLogined(req);
		req.setAttribute("contentsPage", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/edit.go", method = RequestMethod.GET)
	public String editGo(HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			mDAO.getMemberInfo(req);
			req.setAttribute("contentsPage", "member/edit.jsp");
		} else {
			req.setAttribute("contentsPage", "home.jsp");
		}
		return "index";
	}
	
	@RequestMapping(value = "/edit.do", method = RequestMethod.POST)
	public String editDo(Member m, HttpServletRequest req) {
		mDAO.edit(m, req);
		mDAO.isLogined(req);
		req.setAttribute("contentsPage", "home.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public String deleteDo(HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			mDAO.delete(req);
			mDAO.logout(req);
		}
		mDAO.isLogined(req);
		req.setAttribute("contentsPage", "home.jsp");
		
		return "index";
	}

	@RequestMapping(value = "/member.get",
					method = RequestMethod.GET,
					produces = "application/json; charset=utf-8")
	public @ResponseBody Members editGet(Member m) {
		return mDAO.getMemberInfo(m);
	}
}
