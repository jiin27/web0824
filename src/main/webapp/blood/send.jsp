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
		form.action="/blood.do";
		form.method="post";
		form.submit();
	}
</script>
<body>
	<form action="">
		<select name="blood">
			<option value="">혈액형을 선택하세요</option>
			<option value="A">A형</option>
			<option value="B">B형</option>
			<option value="AB">AB형</option>
			<option value="O">O형</option>
		</select>
	</form>
	<button onClick="send()">결과보기</button>
	
</body>
</html>