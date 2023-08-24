<%@page import="org.sp.mvc.domain.Board"%>
<%@page import="org.sp.mvc.model.BoardDAO"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%! BoardDAO boardDAO = new BoardDAO(); %>
<%
	//사용자가 선택한 글의 idx 넘겨받기 
	String board_idx=request.getParameter("board_idx");
	out.print(board_idx);
	
	Board board = boardDAO.select(Integer.parseInt(board_idx));
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

* {
	box-sizing: border-box;
}

input[type=text], select, textarea {
	width: 100%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	margin-top: 6px;
	margin-bottom: 16px;
	resize: vertical;
}

input[type=submit] {
	background-color: #04AA6D;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}

.container {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}
</style>
<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<script type="text/javascript">
function edit(){
	//폼을 전송하려면, POST방식으로 전송한다 
	$("form").attr({
		method:"post", 
		action:"/board/edit"
	});
	
	$("form").submit();//전송!!!	
}

function del(){
	// delete board where board_idx=5;
	location.href="/board/del?board_idx=<%=board.getBoard_idx()%>";
}

$(function(){
	//문서가 로드되면, 편집기를 출력하자 
	$("#content").summernote();
	
	//버튼들에 이벤트 연결 
	$("#bt_list").click(function(){
		
	});
	$("#bt_edit").click(function(){
		if(confirm("수정하시겠어요?")){
			edit();
		}
	});
	$("#bt_del").click(function(){
		if(confirm("삭제하시겠어요?")){
			del();
		}
	});
	
});
</script>

</head>
<body>

	<div class="container">
		<form>
			<input type="text" name="title" value="<%=board.getTitle()%>"> 
			<input type="text" name="writer" value="<%=board.getWriter()%>">
			<textarea id="content" name="content" placeholder="Write something.." style="height: 200px"><%=board.getContent() %></textarea>
			<input type="hidden" name="board_idx" value="<%=board.getBoard_idx()%>">		
			<input type="button" value="목록" id="bt_list">
			<input type="button" value="수정" id="bt_edit">
			<input type="button" value="삭제" id="bt_del">
		</form>
	</div>

</body>
</html>
