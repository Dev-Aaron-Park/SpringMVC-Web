package com.aaron.springmvcproject.comment;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aaron.springmvcproject.board.BoardWriting;
import com.aaron.springmvcproject.member.MemberDAO;
import com.aaron.token.generator.AaronTokenGenerator;

@Controller
public class CommentController {
	
	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private CommentDAO cDAO;
	
	@RequestMapping(value = "/board.comment.do", method = RequestMethod.POST)
	public String commentDo(Comment c, BoardWriting bw, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			AaronTokenGenerator.generate(req);
			cDAO.create(c, bw, req);
			req.setAttribute("contentsPage", "board/detail.jsp");
		} else {
			req.setAttribute("contentsPage", "home.jsp");
		}
		return "index";
	}
	
	@RequestMapping(value = "/board.comment.delete.do", method = RequestMethod.POST)
	public String commentDeleteDo(Comment c, BoardWriting bw, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			cDAO.delete(c, bw, req);
			req.setAttribute("contentsPage", "board/detail.jsp");
		} else {
			req.setAttribute("contentsPage", "home.jsp");
		}
		return "index";
	}
}
