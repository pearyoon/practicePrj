<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<body>
	<h1>마이페이지</h1>
	<form action="/sty09/login/modify" method="post">
		<label for="userId">아이디 : </label>
		<input type="text" id="userId" name="userId" value="${loginMember.id}" readonly>
		<br>
		<label for="userPwd">새 비밀번호 : </label>		
		<input type="password" id="userPwd" name="userPwd1">
		<br>
		<label for="userPwd">새 비밀번호 확인 : </label>		
		<input type="password" id="userPwd" name="userPwd2">
		<br>
		<label for="userName">이름 :</label>
		<input type="text" id="userName" name="userName" value="${loginMember.name}">
		<br>
		<button id="home" type="button">HOME</button>
		<button id="quit" type="button">탈퇴</button>
		<button type="submit">수정</button>
	</form>
	
	<script>
		$('#home').click(function(){
			window.location.href = "/sty09";
		});
	</script>
</body>
</html>