package com.aaron.springmvcproject.gallery;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aaron.springmvcproject.member.MemberDAO;
import com.aaron.token.generator.AaronTokenGenerator;

@Controller
public class GalleryController {
	
	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private GalleryDAO gDAO;
	
	@RequestMapping(value = "/gallery.go", method = RequestMethod.GET)
	public String galleryGo(HttpServletRequest req) {
		AaronTokenGenerator.generate(req);
		mDAO.isLogined(req);
		req.setAttribute("contentsPage", "gallery/main.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/gallery.upload.do", method = RequestMethod.POST)
	public String UploadDo(Gallery g, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			gDAO.upload(g, req);
			req.setAttribute("contentsPage", "gallery/main.jsp");
		} else {
			req.setAttribute("contentsPage", "home.jsp");
		}
		return "index";
	}
}
