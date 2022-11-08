<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<body>
	<h1>회원가입</h1>
	<form action="/sty09/member/join" method="post">
		<label for="userId">아이디 : </label>
		<input type="text" id="userId" name="userId">
		<br>
		<label for="userPwd">비밀번호 : </label>		
		<input type="password" id="userPwd" name="userPwd">
		<br>
		<label for="userName">이름 :</label>
		<input type="text" id="userName" name="userName">
		<br>
		<button type="button">취소</button>
		<button type="submit">회원가입</button>
	</form>
	
	<script>
		$('button[type="button"]').click(function(){
			window.location.href = "/sty09";
		});
	</script>
</body>
</html>