package com.movie.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.web.service.UserService;
import com.movie.web.service.impl.UserServiceImpl;


public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("ui_name");
		String id = request.getParameter("ui_id");
		String email = request.getParameter("ui_email");
		String pwd = request.getParameter("ui_pwd");
		String address = request.getParameter("ui_address");
		String[] genres = request.getParameterValues("ui_genre");
		String genre = "";
		for(int i=0;i<genres.length;i++) {
			genre += genres[i] + ",";
		}
		genre = genre.substring(0,genre.length()-1);
		
		String phone1 = request.getParameter("ui_phone1");
		String phone2 = request.getParameter("ui_phone2");
		String hint = request.getParameter("ui_hint");
		String answer = request.getParameter("ui_answer");
		Map<String,String> user = new HashMap<>();
		user.put("ui_name", name);
		user.put("ui_id", id);
		user.put("ui_email", email);
		user.put("ui_pwd", pwd);
		user.put("ui_address", address);
		user.put("ui_genre", genre);
		user.put("ui_phone1", phone1);
		user.put("ui_phone2", phone2);
		user.put("ui_hint", hint);
		user.put("ui_answer", answer);
		Map<String,String> rMap = userService.insertUser(user);
		request.setAttribute("rMap", rMap);
		ViewServlet.goPage(request, response, "/views/common/msg");
	}

}
