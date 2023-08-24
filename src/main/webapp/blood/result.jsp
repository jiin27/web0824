<%@page import="org.sp.mvc.model.blood.BloodManager"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	//이 jsp 요청과 관련된 session으로부터 어떤 저장된 데이터가 있다면, 
	//꺼내서 결과 메시지로 사용해보자
	String msg=(String)request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%=msg %></h1>
</body>
</html>