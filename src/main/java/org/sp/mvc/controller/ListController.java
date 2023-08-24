package org.sp.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sp.mvc.model.BoardDAO;

public class ListController implements Controller{
	BoardDAO boardDAO=new BoardDAO();
	
	//3단계) 알맞는 로직 객체에 일 시키기
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List boardList=boardDAO.selectAll();
		
		//4단계) jsp에서 보여줄 데이터가 있다면 결과를 저장해놓자
		request.setAttribute("boardList", boardList);
	}

	public String getViewKey() {
		
		return "board/listView";
	}

}
