<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>내정보</h1>
	<form action="/mb03/member/modify" method="post">
		아이디 : <input type="text" name="id" value="${loginMember.memberId }" readonly="readonly">
		<br>
		비밀번호 : <input type="password" name="pwd" value="${loginMember.memberPwd }">
		<br>
		닉네임 : <input type="text" name="nick" value="${loginMember.memberNick}">
		<br>
		<input type="submit" value="수정하기">
	</form>
</body>
</html>