package org.sp.mvc.model.movie;

//이 클래스는 웹이건, 스윙이건 모든 플랫폼에서 재사용이 가능한 순수 로직이다
//즉 MVC 중 Model 영역의 클래스이다.
public class MovieManager {
	
	public String getAdvice(String movie) {
		String msg=null;
		switch(movie) {
		case "미션임파서블": msg="톰크루즈 주연 대작"; break;
		case "범죄도시3": msg="마동석 주연 대작"; break;
		case "엘리멘탈": msg="한국인 감독이 제작"; break;
		case "인어공주": msg="아시아권 폭망"; break;
		}
		
		return msg;
		
	}
}
