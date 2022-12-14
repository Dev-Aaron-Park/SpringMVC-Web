package com.aaron.springmvcproject.comment;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaron.springmvcproject.board.BoardMapper;
import com.aaron.springmvcproject.board.BoardWriting;
import com.aaron.springmvcproject.member.Member;

@Service
public class CommentDAO {

	@Autowired
	private SqlSession ss;
	
	public void create(Comment c, BoardWriting bw, HttpServletRequest req) {
		try {
			String token = req.getParameter("token");
			String lastToken = (String) req.getSession().getAttribute("boardCommentToken");
			
			if (lastToken != null && token.equals(lastToken)) {
				return;
			}
			
			Member m = (Member) req.getSession().getAttribute("loginMember");
			c.setSpc_writer(m.getSpm_id());
			
			if (ss.getMapper(CommentMapper.class).create(c) == 1) {
				req.setAttribute("r", "Success Create");
				req.getSession().setAttribute("boardCommentToken", token);
			} else {
				req.setAttribute("r", "Success Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "Success Failed");
		} finally {
			bw.setSpb_no(new BigDecimal(req.getParameter("spc_board_no")));
			req.setAttribute("bw", ss.getMapper(BoardMapper.class).detail(bw));
			req.setAttribute("comments", ss.getMapper(BoardMapper.class).getComment(bw));
		}
	}
	
	public void delete(Comment c, BoardWriting bw, HttpServletRequest req) {
		try {
			if (ss.getMapper(CommentMapper.class).delete(c) == 1) {
				req.setAttribute("r", "Delete Success");
			} else {
				req.setAttribute("r", "Delete Failed");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "Delete Failed");
		} finally {
			bw.setSpb_no(new BigDecimal(req.getParameter("spc_board_no")));
			req.setAttribute("bw", ss.getMapper(BoardMapper.class).detail(bw));
			req.setAttribute("comments", ss.getMapper(BoardMapper.class).getComment(bw));
		}
	}
}
