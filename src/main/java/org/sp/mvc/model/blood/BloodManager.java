package org.sp.mvc.model.blood;

public class BloodManager {
	
	public String getAdvice(String blood) {
		String msg="";
		
		switch(blood){
		case "A":msg="세심하고 꼼꼼하게 일한다."; break;
		case "B":msg="주관이 뚜렷하다."; break;
		case "AB":msg="결정이 계속 변한다."; break;
		case "O":msg="오지랖이 쓸데없이 넓다."; break;
		}
		
		return msg;
	}
}
