package test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapTest2 {

	public static void main(String[] args) {
		Map<String,String[]> map = new HashMap<>();
		String[] name = {"하하"};
		String[] age = {"33"};
		String[] address = {"seoul"};
		String[] hobby = {"music","travle"};
		map.put("name", name);
		map.put("age", age);
		map.put("address", address);
		map.put("hobby", hobby);
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println("key : " + key);
			String[] values = map.get(key);
			System.out.print("values : ");
			for(String v:values ) {
				System.out.print(v + ",");
			}
			System.out.println();
		}
	}
}
