package com.movie.web.servlet;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_PATH = "C:\\study\\workspace\\movie\\WebContent\\upload";

	private final int FILE_MAX_SIZE = 10 * 1024 * 1024;
	private final int TOTAL_MAX_SIZE = FILE_MAX_SIZE * 10;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if(isMultipart) {
			DiskFileItemFactory dfiFactory = new DiskFileItemFactory();
			
			ServletFileUpload sfu = new ServletFileUpload(dfiFactory);
			sfu.setFileSizeMax(FILE_MAX_SIZE);
			sfu.setSizeMax(TOTAL_MAX_SIZE);
			try {
				List<FileItem> fiList = sfu.parseRequest(request);
				Map<String,String> param = new HashMap<>();
				for(int i=0;i<fiList.size();i++) {
					FileItem fi = fiList.get(i);
					String key = fi.getFieldName();
					String value ="";
					if(fi.isFormField()) {
						value = fi.getString("UTF-8");
					}else {
						long size = fi.getSize();
						if(size!=0) {
							value = fi.getName();
							File saveFile = new File(UPLOAD_PATH + File.separator + value);
							fi.write(saveFile);
						}
					}
					if(!"".equals(value)) {
						param.put(key, value);
					}
				}
				System.out.println(param);
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else {
			
		}
	}

}
