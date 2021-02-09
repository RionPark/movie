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
import com.movie.web.util.MapConvert;

public class UserServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String cmd = MapConvert.getCmd(request.getRequestURI());
		Map<String,String> user = MapConvert.getMap(request.getParameterMap());
		String path = "/views/user/info";
		if("logout".equals(cmd)) {
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("/");
			return;
		}else if("info".equals(cmd)) {
			String uiNumStr = user.get("ui_num");
			int uiNum = Integer.parseInt(uiNumStr);
			Map<String,String> rUser = userService.selectUser(uiNum);
			request.setAttribute("user", rUser);
		}
		ViewServlet.goPage(request, response, path);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		String cmd = MapConvert.getCmd(request.getRequestURI());
		Map<String,String> user = MapConvert.getMap(request);
		Map<String,String> rMap = new HashMap<>();
		String path = "/views/user/login";
		if("login".equals(cmd)) {
			rMap = userService.login(user);
			if("1".equals(rMap.get("result"))) {
				HttpSession session = request.getSession();
				session.setAttribute("user", rMap);
				response.sendRedirect("/");
				return;
			}
		}else if("insert".equals(cmd)) {
			rMap = userService.insertUser(user);
		}else if("update".equals(cmd)) {
			HttpSession session = request.getSession();
			Map<String,String> pUser = (Map<String,String>) session.getAttribute("user");
			if(pUser==null) {
				response.sendRedirect(path);
				return;
			}
			user.put("ui_num", pUser.get("ui_num"));
			rMap = userService.updateUser(user);
			if(!"0".equals(rMap.get("result"))) {
				session.setAttribute("user", rMap);
				path = "/views/user/info";
			}
		}else if("delete".equals(cmd)) {
			HttpSession session = request.getSession();
			Map<String,String> pUser = (Map<String,String>) session.getAttribute("user");
			if(pUser==null) {
				response.sendRedirect(path);
				return;
			}
			user.put("ui_id", pUser.get("ui_id"));
			rMap = userService.deleteUser(user);
			if("0".equals(rMap.get("result"))){
				path = "/views/user/info";
			}else {
				session.invalidate();
				response.sendRedirect("/");
				return;
			}
		}
		request.setAttribute("rMap", rMap);
		ViewServlet.goPage(request, response, path);
	}
}
