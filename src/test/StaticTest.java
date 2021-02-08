package test;

public class StaticTest {
	public static void main(String[] args) {
		String path = "/resources/img/user/" + System.currentTimeMillis();
		System.out.println(path.length());
	}
}
