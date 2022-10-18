<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="/sty08/member/join" method="post" onsubmit="return check()">
		아이디 : <input type="text" name="id">
		<br>
		비밀번호 : <input type="password" name="pwd1">
		<br>
		비밀번호 확인 : <input type="password" name="pwd2">
		<br>
		닉네임 : <input type="text" name="nick">
		<br>
		주소 : <input type="text" name="addr">
		<br>
		번호 : <input type="text" name="phone">
		<br>
		<input type="submit" value="회원가입">
		<button type="button" onclick="location.href='/sty08'">취소</button>
	</form>

	<script>
		const pwd1 = document.querySelector("input[name=pwd1]");
		const pwd2 = document.querySelector("input[name=pwd2]");
		
		function check(){
			if(pwd1.value.length > 3 && pwd1.value == pwd2.value){
				return true;
			} else{
				alert("비밀번호를 확인해주세요.");
				return false;
			}
		}
	</script>
	
</body>
</html>