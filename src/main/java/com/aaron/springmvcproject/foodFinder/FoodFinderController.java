package com.aaron.springmvcproject.foodFinder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aaron.springmvcproject.member.MemberDAO;

@Controller
public class FoodFinderController {
	
	@Autowired
	private MemberDAO mDAO;
	
	@RequestMapping(value = "/foodfinder.go", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		mDAO.isLogined(req);
		req.setAttribute("contentsPage", "foodFinder/main.jsp");
		return "index";
	}
}
