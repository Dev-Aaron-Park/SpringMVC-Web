package com.aaron.springmvcproject.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aaron.springmvcproject.SearchManager;
import com.aaron.springmvcproject.member.MemberDAO;
import com.aaron.token.generator.AaronTokenGenerator;

@Controller
public class BoardController {

	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private BoardDAO bDAO;
	
	@RequestMapping(value = "/board.delete.do", method = RequestMethod.GET)
	public String boardDeleteDo(BoardWriting bw, HttpServletRequest req) {
		bDAO.delete(bw, req);
		mDAO.isLogined(req);
		bDAO.readAllWriting(1, req);
		req.setAttribute("contentsPage", "board/main.jsp");
		return "index";
	}

	@RequestMapping(value = "/board.detail.go", method = RequestMethod.GET)
	public String boardDetailGo(BoardWriting bw, HttpServletRequest req) {
		bDAO.detail(bw, req);
		mDAO.isLogined(req);
		req.setAttribute("contentsPage", "board/detail.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/board.edit.do", method = RequestMethod.GET)
	public String boardEditDo(BoardWriting bw, HttpServletRequest req) {
		// Edit
		mDAO.isLogined(req);
		req.setAttribute("contentsPage", "board/detail.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/board.edit.go", method = RequestMethod.GET)
	public String boardEditGo(BoardWriting bw, HttpServletRequest req) {
		bDAO.detail(bw, req);
		mDAO.isLogined(req);
		req.setAttribute("contentsPage", "board/edit.jsp");
		return "index";
	}

	@RequestMapping(value = "/board.go", method = RequestMethod.GET)
	public String boardGo(
			@RequestParam(value="page") int p,
			HttpServletRequest req) {
		mDAO.isLogined(req);
		SearchManager.clearSearch(req);
		bDAO.readAllWriting(p, req);
		req.setAttribute("contentsPage", "board/main.jsp");
		return "index";
	}

	@RequestMapping(value = "/board.search", method = RequestMethod.GET)
	public String boardSearch(
			HttpServletRequest req) {
		mDAO.isLogined(req);
		SearchManager.search(req);
		bDAO.readAllWriting(1, req);
		req.setAttribute("contentsPage", "board/main.jsp");
		return "index";
	}

	@RequestMapping(value = "/board.write.do", method = RequestMethod.POST)
	public String writeDo(BoardWriting bw, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			bDAO.create(bw, req);
			AaronTokenGenerator.generate(req);
		}
		bDAO.readAllWriting(1, req);
		req.setAttribute("contentsPage", "board/main.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "/board.write.go", method = RequestMethod.GET)
	public String writeGo(HttpServletRequest req) {
		mDAO.isLogined(req);
		AaronTokenGenerator.generate(req);
		req.setAttribute("contentsPage", "board/write.jsp");

		return "index";
	}
}
