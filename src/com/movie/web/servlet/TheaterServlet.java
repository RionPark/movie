package com.movie.web.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.web.service.TheaterService;
import com.movie.web.service.impl.TheaterServiceImpl;
import com.movie.web.util.MapConvert;

public class TheaterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private TheaterService theaterService = new TheaterServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = MapConvert.getCmd(request.getRequestURI());
		Map<String,String> theater = MapConvert.getMap(request);
		if("list".equals(cmd)) {
			List<Map<String,String>> theaterList = theaterService.selectTheaterList(theater);
			request.setAttribute("theaterList", theaterList);
		}else if("view".equals(cmd)) {
			int tiNum = Integer.parseInt(theater.get("ti_num"));
			Map<String,String> rTh =  theaterService.selectTheater(tiNum);
			request.setAttribute("theater", rTh);
		}
		ViewServlet.goPage(request, response, "/views" + request.getRequestURI());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cmd = MapConvert.getCmd(request.getRequestURI());
		Map<String,String> theater = MapConvert.getMap(request);
		if("insert".equals(cmd)) {
			Map<String,String> rMap = theaterService.insertTheater(theater);
			request.setAttribute("rMap", rMap);
		}
		ViewServlet.goPage(request, response, "/views/theater/insert");
	}

}
