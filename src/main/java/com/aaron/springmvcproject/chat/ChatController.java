package com.aaron.springmvcproject.chat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aaron.springmvcproject.member.MemberDAO;
import com.aaron.token.generator.AaronTokenGenerator;

@Controller
public class ChatController {
	
	@Autowired
	private MemberDAO mDAO;
	
	
	@RequestMapping(value = "/chat.go", method = RequestMethod.GET)
	public String chatGo(HttpServletRequest req) {
		AaronTokenGenerator.generate(req);
		mDAO.isLogined(req);
		req.setAttribute("contentsPage", "chat/main.jsp");
		return "index";
	}
}
