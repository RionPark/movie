package com.movie.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.web.service.UserService;
import com.movie.web.service.impl.UserServiceImpl;


public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURI();
		int idx = url.lastIndexOf("/");
		String cmd = url.substring(idx+1);
		if("logout".equals(cmd)) {
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("/views/user/login");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = request.getRequestURI();
		int idx = url.lastIndexOf("/");
		String cmd = url.substring(idx+1);
		String[] genres = request.getParameterValues("ui_genre");
		String genre = "";
		if(genres!=null) {
			for(int i=0;i<genres.length;i++) {
				genre += genres[i] + ",";
			}
			genre = genre.substring(0,genre.length()-1);
		}
		Map<String,String> user = new HashMap<>();
		user.put("ui_name", request.getParameter("ui_name"));
		user.put("ui_id", request.getParameter("ui_id"));
		user.put("ui_email", request.getParameter("ui_email"));
		user.put("ui_pwd", request.getParameter("ui_pwd"));
		user.put("ui_address", request.getParameter("ui_address"));
		user.put("ui_genre", genre);
		user.put("ui_phone1", request.getParameter("ui_phone1"));
		user.put("ui_phone2", request.getParameter("ui_phone2"));
		user.put("ui_hint", request.getParameter("ui_hint"));
		user.put("ui_answer", request.getParameter("ui_answer"));
		String path = "/views/common/msg";
		Map<String,String> rMap = new HashMap<>();
		if("login".equals(cmd)) {
			rMap = userService.login(user);
			path = "/views/user/login";
			if("1".equals(rMap.get("result"))) {
				path = "/views/index";
				HttpSession session  = request.getSession();
				session.setAttribute("user", rMap);
			}
		}else if("insert".equals(cmd)) {
			rMap = userService.insertUser(user);
		}
		request.setAttribute("rMap", rMap);
		ViewServlet.goPage(request, response, path);
	}

}
