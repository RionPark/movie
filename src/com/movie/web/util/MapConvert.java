package com.movie.web.util;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class MapConvert {
	private static final String UPLOAD_PATH = "C:\\study\\workspace\\movie\\WebContent\\upload";

	private final int FILE_MAX_SIZE = 10 * 1024 * 1024;
	private final int TOTAL_MAX_SIZE = FILE_MAX_SIZE * 10;
	
	public static String getCmd(String uri) {
		int idx = uri.lastIndexOf("/");
		uri = uri.substring(idx+1);
		return uri;
	}

	public static Map<String,String> getMap(Map<String,String[]> paramMap){
		Map<String,String> param = new HashMap<>();
		Iterator<String> it = paramMap.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			String[] values = paramMap.get(key);
			String value = "";
			for(int i=0;i<values.length;i++) {
				value += values[i] + ",";
			}
			value = value.substring(0,value.length()-1);
			param.put(key, value);
		}
		return param;
	}
	
	public static Map<String,String> getMapFromList(HttpServletRequest request){
		DiskFileItemFactory dfiFactory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(dfiFactory);
		List<FileItem> fiList;
		try {
			fiList = sfu.parseRequest(request);
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
						int idx = value.lastIndexOf(".");
						if(idx==-1) {
							throw new ServletException("인식할 수 없는 확장자입니다.");
						}
						String ext = value.substring(idx);
						value = System.nanoTime() + ext;
						File saveFile = new File(UPLOAD_PATH + File.separator + value);
						fi.write(saveFile);
					}
				}
				if(!"".equals(value)) {
					param.put(key, value);
				}
			}
			return param;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static Map<String,String> getMap(HttpServletRequest request){
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if(isMultipart) {
			return getMapFromList(request);
		}else {
			return getMap(request.getParameterMap());
		}
	}
}
