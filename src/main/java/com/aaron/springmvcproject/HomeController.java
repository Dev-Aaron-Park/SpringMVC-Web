package com.aaron.springmvcproject;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aaron.springmvcproject.board.BoardDAO;
import com.aaron.springmvcproject.member.MemberDAO;

@Controller
public class HomeController {
	
	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private BoardDAO bDAO;
	
	private boolean firstReq;
	
	public HomeController() {
		firstReq = true;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		if (firstReq) {
			bDAO.setReadAllCount(new PageManager("", null, null));
			firstReq = false;
		}
		mDAO.isLogined(req);
		req.setAttribute("contentsPage", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String index(HttpServletRequest req) {
		mDAO.isLogined(req);
		req.setAttribute("contentsPage", "home.jsp");
		return "index";
	}
	
}
