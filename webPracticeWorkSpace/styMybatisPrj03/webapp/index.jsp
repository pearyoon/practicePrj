<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>스프링들어가기전연습!</h1>
	<c:if test="${loginMember.memberNick eq '관리자'}">
		<a href="/mb03/member/list?p=1">회원조회</a>
		<br>
	</c:if>
	<c:if test="${loginMember != null }">
		<a href="/mb03/member/modify">내 정보</a>
	
	</c:if>
	<c:if test="${loginMember == null }">
		<a href="/mb03/member/join">회원가입</a>
		<hr>
		<a href="/mb03/member/login">로그인</a>
	</c:if>
	
</body>
</html>