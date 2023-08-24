package org.sp.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sp.mvc.model.blood.BloodManager;
import org.sp.mvc.model.movie.MovieManager;

//혈액형 요청을 전담하여 처리하는 하위 컨트롤러
public class MovieController implements Controller{
	MovieManager manager;
	
	//3단계) 일 시키기
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 꺼내기
		String movie=request.getParameter("movie");
		manager=new MovieManager();
		String msg=manager.getAdvice(movie);
		
		//4단계) 결과 페이지로 가져갈 데이터 저장
		request.setAttribute("msg", msg);
	}
	
	public String getViewKey() {
		return "movieView";
	}
}


