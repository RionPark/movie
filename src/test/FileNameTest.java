package test;

public class FileNameTest {

	public static void main(String[] args) {
		String fileName = "가을 일러스트 그림복사.2.jpg";
		int idx = fileName.lastIndexOf(".");
		if(idx==-1) {
			System.out.println("장난치냐~~ 이미지 똑바로 보내라잉~");
			return;
		}
		String extName = fileName.substring(idx);
		fileName = System.nanoTime() + "";
		fileName += extName;
		System.out.println("KAKAOTALK_" + fileName);
	}
}
