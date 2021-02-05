package test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("name", "하하");
		map.put("age", "33");
		map.put("address", "seoul");
		map.put("hobby", "travle");
		
		Map<String,String> param = new HashMap<>();
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			param.put(key, map.get(key));
		}
		System.out.println(param);
	}
}
