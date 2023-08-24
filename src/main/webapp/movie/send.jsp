<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function send() {		
		//혈액형에 대한 판단결과를 요청하자
		let form=document.querySelector("form");
		form.action="/movie.do";
		form.method="post";
		form.submit();
	}
</script>
<body>
	<form action="">
		<select name="movie">
			<option value="">영화를 선택하세요</option>
			<option value="미션임파서블">미션임파서블</option>
			<option value="범죄도시3">범죄도시3</option>
			<option value="엘리멘탈">엘리멘탈</option>
			<option value="인어공주">인어공주</option>
		</select>
	</form>
	<button onClick="send()">결과보기</button>
	
</body>
</html>