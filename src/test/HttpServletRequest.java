package test;

import java.util.HashMap;
import java.util.Map;

public class HttpServletRequest {

	private Map<String,String[]> params = new HashMap<>();
	
	HttpServletRequest(){
		params.put("input1", new String[]{""});
		params.put("genre", new String[] {"코메디","스릴러","범죄"});
	}
	public String getParameter(String key) {
		String[] values = params.get(key);
		if(values==null) {
			return null;
		}
		return values[0];
	}
	public String[] getParameterValues(String key) {
		return params.get(key);
	}
	
	public static void main(String[] args) {
		HttpServletRequest request = new HttpServletRequest();
		String input1 = request.getParameter("input1");
		System.out.println(input1);
		String[] genres = request.getParameterValues("genre");
		String genre = "";
		if(genres!=null) {
			for(int i=0;i<genres.length;i++) {
				genre += genres[i] + ",";
			}
		}
		System.out.println(genre);
	}
}
