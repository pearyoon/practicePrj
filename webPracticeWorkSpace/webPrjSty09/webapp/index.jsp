<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입/로그인 연습</title>
</head>
<body>
	<h1>회원가입/로그인 연습</h1>
	<c:if test="${loginMember == null}">
		<a href="/sty09/member/join">회원가입</a>
		<br>
		<a href="/sty09/member/login">로그인</a>
	</c:if>
	<c:if test="${loginMember.id eq 'admin' }">
		<a href="/sty09/admin/member/list">회원조회</a>
		<br>		
	</c:if>
	<c:if test="${loginMember != null}">
		<a href="/sty09/member/logout">로그아웃</a>
	</c:if>
	

</body>
</html>