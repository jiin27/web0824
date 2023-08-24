<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page import="java.io.IOException" %>
<%@ page contentType="text/html; charset=UTF-8"%>

<%
	//클라이언트가 전송한 텍스트데이터 + 바이너리 파일을 전송받아 정보를 출력
	//원하는 위치에 저장 (업로드 컴포넌트가 알아서 처리함..)
	
	//클라이언트의 데이터 전송이 텍스트 데이터 뿐만 아니라, 바이너리 형식의 데이터도 포함되어 있을 경우
	//request.getParameter() 메서드로는 텍스트만 받을 수 있고, 바이너리 형식의 데이터는 별도의
	//스트림 처리가 필요하다..하지만 개발의 효율성이 떨어지므로, 이미 잘 작성된 외부 컴포넌트를 이용해보자
	
	//어플리케이션 자체의 정보를 개발자가 직접 얻지 말고, 프로그래밍적으로 얻을 수 있는 방법을 이용하자 
	//jsp의 내장객체 9 개중, application 내장객체: 웹어플리케이션과 관련된 컨텍스트
	
	//현재의 jsp 즉 서블릿이 실행중인 웹어플리케이션의 루트의 하위에 있는 data 디렉토리의
	//하드디스크상 풀 경로 얻기 
	//현재 개발중인 이클립스가 아니라, 고양이 서버에 배포된 어플리케이션의 위치를 기준으로 한다
	String path=application.getRealPath("/data");
	out.print(path); 
	int maxSize=1024*1024*1; //제한할 파일의 용량
	
	//생성자 호출만 해도, 지정한 경로에 파일이 자동으로 업로드 된다..
	// 생성자 메서드엔 IOException이 throws 되어 있으므로, 현재 스크립틀릿에서 그 예외를
	//처리하도록 하자 
	try{
		MultipartRequest multi=new MultipartRequest(request, path, maxSize,"utf-8");
	}catch(IOException e){
		out.print("용량은 1메가를 넘어설 수 없습니다");
	}
	
%>




