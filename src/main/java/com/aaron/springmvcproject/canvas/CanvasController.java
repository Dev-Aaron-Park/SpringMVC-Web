package com.aaron.springmvcproject.canvas;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aaron.springmvcproject.member.MemberDAO;

@Controller
public class CanvasController {
	
	@Autowired
	private MemberDAO mDAO;
	
	
	@RequestMapping(value = "/canvas.go", method = RequestMethod.GET)
	public String canvasGo(HttpServletRequest req) {
		mDAO.isLogined(req);
		req.setAttribute("contentsPage", "canvas/main.jsp");
		return "index";
	}
}