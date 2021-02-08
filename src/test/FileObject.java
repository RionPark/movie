package test;

import java.util.ArrayList;
import java.util.List;

class FileItem{
	FileItem(String name, String string, String fieldName, boolean formField){
		this.name = name;
		this.string = string;
		this.fieldName = fieldName;
		this.formField = formField;
	}
	boolean formField;
	private String name;
	private String string;
	private String fieldName;
	
	public boolean isFormField() {
		return formField;
	}
	public void setFormField(boolean formField) {
		this.formField = formField;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	public String getFeildName() {
		return fieldName;
	}
	public void setFeildName(String fieldName) {
		this.fieldName = fieldName;
	}
	
}
public class FileObject {

	public static void main(String[] args) {
		List<FileItem> fiList = new ArrayList<>();
		//String name, String string, String fieldName
		FileItem fi1 = new FileItem("음식.jpg",null,"img",false);
		FileItem fi2 = new FileItem(null,"redfila","id",true);
		fiList.add(fi1);
		fiList.add(fi2);
		
		for(int i=0;i<fiList.size();i++) {
			FileItem fi = fiList.get(i);
			String key = fi.getFeildName();
					
			if(fi.isFormField()) {
				String value = fi.getString();
				System.out.println(key + "폼필드니까 value값은? : " + value);
			}else {
				String fileName = fi.getName();
				System.out.println(key + "파일필드니까 파일명은? : " + fileName);
			}
		}
	}
}
