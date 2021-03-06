package com.movie.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String PREFIX = "/WEB-INF";
    private static final String SUFFIX = ".jsp";
   
    public static void goPage(HttpServletRequest request,HttpServletResponse response
    		, String path) throws ServletException, IOException {
    	RequestDispatcher rd = request.getRequestDispatcher(PREFIX + path + SUFFIX);
    	rd.forward(request, response);
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRequestURI();
		RequestDispatcher rd = request.getRequestDispatcher(PREFIX + path + SUFFIX);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
