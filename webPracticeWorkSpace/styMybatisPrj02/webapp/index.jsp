<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>마이바티스 혼자 연습</h1>
	<c:if test="${loginMem != null }">
		<h1>${loginMem.nick }</h1>
		<br>
		<a href="/mb02/board/list">게시판</a>
	</c:if>
	<c:if test="${loginMem == null}">
		<a href="/mb02/member/join">회원가입</a>
		<br>
		<a href="/mb02/member/login">로그인</a>
	</c:if>


</body>
</html>