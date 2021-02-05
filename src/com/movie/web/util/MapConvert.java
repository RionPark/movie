package com.movie.web.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapConvert {
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
}
