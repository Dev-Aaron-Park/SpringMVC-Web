package com.aaron.springmvcproject.board;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaron.springmvcproject.PageManager;
import com.aaron.springmvcproject.SMPAttribute;
import com.aaron.springmvcproject.member.Member;

@Service
public class BoardDAO {
	private int readAllCount;
	
	@Autowired
	private SMPAttribute smpAttr;
	
	@Autowired
	private SqlSession ss;
	
	public void setReadAllCount(PageManager pm) {
		readAllCount = ss.getMapper(BoardMapper.class).readAllCount(pm);
	}
	
	public void setReadAllCount(int count) {
		readAllCount -= count;
	}
	
	private void regAIData(BoardWriting bw, HttpServletRequest req) {
		HttpsURLConnection huc = null;
		try {
			
			URL u = new URL("https://api.openweathermap.org/data/2.5/weather?q=seoul&appid=baff8f3c6cbc28a4024e336599de28c4&units=metric&lang=kr");
			huc = (HttpsURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			JSONParser jp = new JSONParser();
			JSONObject jo = (JSONObject) jp.parse(isr);
			JSONArray weather = (JSONArray) jo.get("weather");
			JSONObject weather0 = (JSONObject) weather.get(0);
			String description = (String) weather0.get("description");
			JSONObject main = (JSONObject) jo.get("main");
			BigDecimal temp = new BigDecimal(main.get("temp").toString());
			BigDecimal humidity = new BigDecimal(main.get("humidity").toString());
			
			String hour = new SimpleDateFormat("HH").format(new Date());
			
		} catch (Exception e) {

		}
	}
	
	public void create(BoardWriting bw, HttpServletRequest req) {
		try {
			
			String token = req.getParameter("token");
			String lastToken = (String) req.getSession().getAttribute("boardWritingToken");
			
			if (lastToken != null && token.equals(lastToken)) {
				return;
			}
			
			Member m = (Member) req.getSession().getAttribute("loginMember");
			bw.setSpb_writer(m.getSpm_id());
			bw.setSpb_color("#EEEEEE");
			if (ss.getMapper(BoardMapper.class).create(bw) == 1) {
				req.setAttribute("r", "Write Success");
				req.getSession().setAttribute("boardWritingToken", token);
				regAIData(bw, req);
				readAllCount++;
			} else {
				req.setAttribute("r", "Write Failed");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "Write Failed");
		}
	}

	public void delete(BoardWriting bw, HttpServletRequest req) {
		try {
			bw.setSpb_no(new BigDecimal(req.getParameter("no")));
			ss.getMapper(BoardMapper.class).delete(bw);
			readAllCount--;
			req.setAttribute("r", "Delete Success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void detail(BoardWriting bw, HttpServletRequest req) {
		try {
			bw.setSpb_no(new BigDecimal(req.getParameter("no")));
			req.setAttribute("bw", ss.getMapper(BoardMapper.class).detail(bw));
			req.setAttribute("comments", ss.getMapper(BoardMapper.class).getComment(bw));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void readAllWriting(int page, HttpServletRequest req) {
		try {
			setReadAllCount(new PageManager("", null, null)); // 삭제
			
			int perPage = smpAttr.getBoardPerPage();
			int readCount = readAllCount;
			int start = (page - 1) * perPage + 1;
			int end = perPage * page;
			PageManager pm = new PageManager("", new BigDecimal(start), new BigDecimal(end));
			String keyword = (String) req.getSession().getAttribute("keyword"); 
			
			if (keyword != null) {
				pm.setKeyword(keyword);
				readCount = ss.getMapper(BoardMapper.class).readAllCount(pm);
			}
			
			req.setAttribute("bwArr", ss.getMapper(BoardMapper.class).readAllWriting(pm));
			
			int pageCount = (int) Math.ceil(readCount / (double) perPage);
			req.setAttribute("pageCount", pageCount);
			req.setAttribute("page", page);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void edit(BoardWriting bw, HttpServletRequest req) {
		try {
			bw.setSpb_content(bw.getSpb_content().replace("\r\n", "<br>"));
			if (ss.getMapper(BoardMapper.class).edit(bw) == 1) {
				req.setAttribute("r", "Edit Success");
				req.setAttribute("bw", ss.getMapper(BoardMapper.class).detail(bw));
			} else {
				req.setAttribute("r", "Edit Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "Edit Failed");
		}
	}

}
