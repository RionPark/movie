package test;

import java.util.HashMap;
import java.util.Map;

public class TimeTest {

	public static void main(String[] args) {
		Map<String,String[]> params = new HashMap<>();
		String[] strs = params.get("genre");
		String str = "";
		for(int i=0;i<strs.length;i++) {
			str += strs[i];
		}
		System.out.println(str);
	}
}
