<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String alertMsg = (String)session.getAttribute("alertMsg");
	session.removeAttribute("alertMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		<%if (alertMsg != null) {%>
			alert("<%=alertMsg%>");
		
		<%}%>
	</script>
	<h1>로그인</h1>
	<form action="/sty08/member/login" method="post">
		아이디 : <input type="text" name="id">
		<br>
		비밀번호 : <input type="password" name="pwd">
		<br>
		<input type="submit" value="로그인">
	</form>
</body>
</html>