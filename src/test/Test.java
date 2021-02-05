package test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Test {

	
	public static void main(String[] args) {
		String genre="스릴러,반전,추리";

		System.out.println(genre.contains("스릴러")?"checked":"");
		System.out.println(genre.contains("반전")?"checked":"");
		System.out.println(genre.contains("추리")?"checked":"");
		System.out.println(genre.contains("미스터리")?"checked":"");
	}
}
