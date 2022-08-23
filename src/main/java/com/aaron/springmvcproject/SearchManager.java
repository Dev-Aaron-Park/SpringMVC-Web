package com.aaron.springmvcproject;

import javax.servlet.http.HttpServletRequest;

public class SearchManager {
	public static void clearSearch(HttpServletRequest req) {
		req.getSession().setAttribute("keyword", null);
	}

	public static void search(HttpServletRequest req) {
		String keyword = req.getParameter("keyword");
		req.getSession().setAttribute("keyword", keyword == null ? "" : keyword);
	}
}
