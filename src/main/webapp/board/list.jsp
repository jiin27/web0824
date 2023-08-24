<%@page import="org.sp.mvc.domain.Board"%>
<%@page import="java.util.List"%>
<%@page import="org.sp.mvc.model.BoardDAO"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%!
	
%>
<%
	List<Board> boardList=(List)request.getAttribute("boardList");
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
table {
	border-collapse: collapse;
	border-spacing: 0;
	width: 100%;
	border: 1px solid #ddd;
}

th, td {
	text-align: left;
	padding: 16px;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}

a{
	text-decoration:none;
}

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$("button").click(function(){
		$(location).attr("href","/board/registform.jsp");	 
	});	
});
</script>

</head>
<body>


	<table>
		<tr>
			<th>No</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
		<%for(int i=0;i<boardList.size();i++){ %>
		<%Board board = boardList.get(i); %>
		<tr>
			<td>Jill</td>
			<td><a href="/board/content.jsp?board_idx=<%=board.getBoard_idx()%>"><%=board.getTitle() %></a></td>
			<td><%=board.getWriter() %></td>
			<td><%=board.getRegdate() %></td>
			<td><%=board.getHit() %></td>
		</tr>
		<%} %>
		<tr>
			<td colspan="5" align="center">
				[1][2][3][4]
			</td>
		</tr>
		
		<tr>
			<td colspan="5"">
				<button>글쓰기</button>
			</td>
		</tr>

	</table>

</body>
</html>
