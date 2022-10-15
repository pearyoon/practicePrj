<%@page import="com.kh.sty08.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>회원가입/로그인/회원정보조회 연습</h1>
	<%if(loginMember != null) {%>
		<a href="/sty08/member/mypage">마이페이지</a>
		<br>
		<a href="/sty08/member/logout">로그아웃</a>
	<%} else {%>
		<a href="/sty08/member/join">회원가입</a>
		<br>
		<a href="/sty08/member/login">로그인</a>
	<%} %>

	
</body>
</html>